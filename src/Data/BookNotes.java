package Data;

import util.LinkedList;

public class BookNotes extends Notes {
    
    //TODO eliminar la variable id (la creé por si usabamos txt para juntar notas con libros, pero como usamos json ya no hace falta)
    
    
    private LinkedList<Notes> bookNotes;
    //TODO generar metodo para ordenar notas por página
    //(idea:¿es posible almacenar las notas en árboles binarios en vez de listas para agilizar la búsqueda?)
    
    //setters
    
    public void setBookNotes  (LinkedList<Notes> bookNotes){
        this.bookNotes= bookNotes;
    }
    //getters
    
    public LinkedList<Notes> getBookNotes(){
        return this.bookNotes;
    }
    
    
    

    public BookNotes() {
        System.out.println("Data.BookNotes.<init>()");
        bookNotes= new LinkedList<Notes>();
        
    }
    
    public BookNotes(LinkedList<Notes> bookNotes) {
        this.bookNotes= bookNotes;
        
    }
    
    public void deleteNote(int noteToClean){
        this.bookNotes.deletePosition(noteToClean);
    }
    
    public void addNote(Notes newNote){
        this.bookNotes.insertEnd(newNote);
    }
    
    public String paintBookNotes(){
        //add note to string into a note
        String s = " {";
        for(int i = 0; i<this.bookNotes.count;i++){
            s= s + "nota No."+i+" :[" + this.bookNotes.elementPosition(i).paintNote()+ "] ";
        }
        s = s+ "} ";
        return " [ *"+ s +"* ]";
    }
    
    //

}
