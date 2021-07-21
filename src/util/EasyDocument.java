/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Diego Quintero
 */
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.IOException;
import java.util.HashMap;

public class EasyDocument {
    private final PDDocument doc;
    private PDPageContentStream content;
    private PDFont titleFont;
    private PDFont subTitleFont;
    private PDFont nSubTitleFont;
    private PDFont textFont;
    private int STNum;
    private int SSTNum;
    private int SSSTNum;
    private int pagination;
    private float textSize;
    private float titleSize;
    private float subTitleSize;
    private float indentation;
    private float leading;
    private float marginX;
    private float marginY;
    private float startX;
    private float startY;
    private float actualX;
    private float actualY;
    private float usableWidth;
    private float usableHeight;
    private String aligned;

    public EasyDocument() throws IOException {
        this.doc=new PDDocument();
        this.setStandardValues();
        this.addPage();
    }

    protected PDDocument getDoc(){
        return this.doc;
    }
    public void setMarginX(float marginX){
        this.marginX=marginX;
    }
    public void setMarginY(float marginY){
        this.marginY=marginY;
    }
    public void setTitleSize(float titleSize){
        this.titleSize=titleSize;
    }
    public void setFontSize(float fontSize){
        this.textSize=fontSize;
    }
    public void setLeading(float leading){
        this.leading=leading;
    }
    public void setTitleFont(float titleSize, PDFont titleFont){
        this.titleSize=titleSize;
        this.titleFont=titleFont;
    }
    public void setIndentation(float indentation){
        this.indentation=indentation;
    }
    public void overlay(String pdfName , int startPage) throws IOException{
        if(startPage>doc.getNumberOfPages()) return;
        HashMap<Integer, String> overlayGuide = new HashMap<>();
        for(int i=startPage; i<doc.getNumberOfPages(); i++)
            overlayGuide.put(i+1, pdfName);
        Overlay overlay = new Overlay();
        overlay.setInputPDF(doc);
        overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
        overlay.overlay(overlayGuide);
    }

    public void title(String title) throws IOException {
        this.content.setFont(this.titleFont, this.titleSize);
        fitAndWrite(title, this.titleSize, this.titleFont);
        this.STNum=this.SSTNum=this.SSSTNum=0;
    }
    public void subTitleI(String sTitle, boolean numeration) throws IOException{
        this.content.setFont(this.subTitleFont, this.subTitleSize);
        fitAndWrite(numeration? ++this.STNum+") "+ sTitle : sTitle, this.subTitleSize, this.subTitleFont);
        this.SSTNum=this.SSSTNum=0;
    }
    public void subTitleII(String ssTitle, boolean numeration) throws IOException{
        this.content.setFont(this.nSubTitleFont, this.textSize);
        fitAndWrite(numeration? STNum +"."+ ++this.SSTNum +") "+ ssTitle : ssTitle, this.textSize, this.nSubTitleFont);
        this.SSSTNum=0;
    }
    public void subTitleIII(String sssTitle, boolean numeration) throws IOException{
        this.content.setFont(this.nSubTitleFont, this.textSize);
        fitAndWrite(numeration? this.STNum +"."+ this.SSTNum +"."+ ++this.SSSTNum+") "+ sssTitle : sssTitle, this.textSize, this.nSubTitleFont);
    }
    public void paragraph(String paragraph) throws IOException{
        this.content.setFont(this.textFont, this.textSize);
        fitAndWrite(paragraph,this.textSize,this.textFont);
    }

    @Deprecated//Obsoleto por mal funcionamiento y limitado al no poder establecer su posición
    public void drawImage(String imageName, float scale) throws IOException {
        content.endText();
        PDImageXObject watermarkImage = PDImageXObject.createFromFile(imageName,doc);
        float xCoordinate=(this.usableWidth-watermarkImage.getWidth()*scale)/2+marginX;
        float yCoordinate=(this.usableHeight-watermarkImage.getHeight()*scale)/2+marginY;
        this.content.drawImage(watermarkImage, xCoordinate, yCoordinate,watermarkImage.getWidth()*scale,watermarkImage.getHeight()*scale);
        content.beginText();
        this.newLineAtAbsoluteOffset(startX,this.usableHeight/2+marginY);
    }

    public void centerAligned(){
        this.aligned="C";
    }
    public void leftAligned(){
        this.aligned="L";
    }
    public void rightAligned(){
        this.aligned="R";
    }

    public void smallSkip() throws IOException{
        this.newLineAtAbsoluteOffset(startX,actualY-leading);
    }
    public void medSkip() throws IOException{
        this.newLineAtAbsoluteOffset(startX,actualY-leading*1.5f);
    }
    public void bigSkip() throws IOException{
        this.newLineAtAbsoluteOffset(startX,actualY-leading*2f);
    }

    public void export(String fileName) throws IOException{
        this.content.endText();
        this.content.close();
        this.doc.save(fileName);
        System.out.println("The PDF has been created successfully");
    }

    
    public void merge(String fileDestination, String... fileNames) throws IOException{
        PDFMergerUtility PDFMerger = new PDFMergerUtility();
        for(String fileName : fileNames)
            PDFMerger.addSource(fileName);
        PDFMerger.setDestinationFileName(fileDestination);
        PDFMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        System.out.println("The PDFs has been merged successfully");

    }

    public void addPage() throws IOException{
        if(this.content!=null){
            this.content.endText();
            this.content.close();
        }
        this.doc.addPage(new PDPage());
        this.content=new PDPageContentStream(this.doc, this.doc.getPage(pagination));
        this.setMediaBox(doc.getPage(pagination));
        this.pagination++;
        this.content.beginText();
        this.content.newLineAtOffset(startX,startY);
    }
    private void fitAndWrite(String text, float fontSize, PDFont font) throws IOException{
        float textWidth = fontSize*font.getStringWidth(text)/1000f;
        if(this.pageIsFull()) this.addPage();
        if(textWidth <= this.usableWidth-this.indentation){
            this.content.setFont(font,fontSize);
            this.setAlignOffSet(textWidth);
            this.content.showText(text);
        }else{
            String[] arrayText=text.split(" ");
            MyStack<String> detachedText = new MyStack<>(arrayText);//Por optimizar
            MyQueue<String> lines = new MyQueue<>();
            String auxString = "";
            String line="";

            while(!detachedText.isEmpty()){
                auxString+=detachedText.peek()+" ";
                float auxStringWidth=fontSize*font.getStringWidth(auxString)/1000f;
                if(auxStringWidth>this.usableWidth-this.indentation || detachedText.numberOfElements()==1){
                    lines.enqueue(detachedText.numberOfElements()==1? line+detachedText.peek() : line);
                    auxString=detachedText.peek()+" ";
                }
                detachedText.pop();
                line=auxString;
            }
            while(!lines.isEmpty()){
                this.content.setFont(font,fontSize);
                line=lines.dequeue();
                float lineWidth=fontSize*font.getStringWidth(line)/1000f;
                setAlignOffSet(lineWidth);
                this.content.showText(line);
                if(this.pageIsFull()) this.addPage();
            }
        }
    }
    private void setAlignOffSet(float stringWidth) throws IOException{
        switch (aligned){
            case("L"):
                this.newLineAtAbsoluteOffset(startX+indentation,actualY-leading);
            break;
            case("C"):
                this.newLineAtAbsoluteOffset(startX+(usableWidth-stringWidth)/2+indentation, actualY-leading);
            break;
            case("R"):
                this.newLineAtAbsoluteOffset(startX+usableWidth-stringWidth+indentation,actualY-leading);
            break;
        }
    }
    private void setMediaBox(PDPage page){
        PDRectangle box = page.getMediaBox();
        this.usableWidth= box.getWidth()-2*marginX;
        this.usableHeight= box.getHeight()-2*marginY;
        this.startX=this.actualX= box.getLowerLeftX()+this.marginX;
        this.startY=this.actualY= box.getUpperRightY()-this.marginY;
    }
    private void setStandardValues(){
        this.textSize=12f;
        this.titleSize=20f;
        this.subTitleSize=14f;
        this.STNum=this.SSTNum=this.SSSTNum=0;
        this.marginX=this.marginY=70f;
        this.aligned="L";
        this.pagination=0;
        this.leading=14.5f;
        this.indentation=0f;
        this.titleFont=PDType1Font.HELVETICA_BOLD;
        this.textFont=PDType1Font.HELVETICA;
        this.subTitleFont=PDType1Font.HELVETICA_BOLD;
        this.nSubTitleFont=PDType1Font.HELVETICA_BOLD_OBLIQUE;
    }
    private void newLineAtAbsoluteOffset(float x, float y) throws IOException {
        this.content.newLineAtOffset(x-actualX,y-actualY);
        this.actualX=x;
        this.actualY=y;
    }
    private boolean pageIsFull(){
        return this.actualY-this.leading<this.marginY;
    }
}