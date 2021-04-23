package util;

import Data.Book;
import Data.BookInformation;
import Data.BookNotes;
import Data.MyBooks;
import Data.Notes;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Test {
    public static void main(String[] args)throws IOException {
        //Creando libros

        BookInformation informacion1 = new BookInformation(1,"Caperucita",
                "anonimo","fabula","222200");
        BookNotes nota1 = new BookNotes(1);
        Book libro1 = new Book(informacion1, nota1, 0, true,"");
        libro1.getNotes().addNote(new Notes("", 69, 3,""));
        libro1.getNotes().addNote(new Notes("", 23, 3,"SADFGHJGFDSA"));

        LinkedList<Book> listaLibros = new LinkedList<>();

        BookInformation informacion2 = new BookInformation(2,"Principito",
                "anonimo","Historia","22110");
        BookNotes nota2 = new BookNotes(2);
        Book libro2 = new Book(informacion2, nota2, 32, true,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse accumsan lorem eu quam ornare, eget egestas tortor pretium. Maecenas ut ante a lorem dictum tincidunt. Phasellus commodo fringilla maximus. Vivamus nec ipsum mattis, accumsan massa non, eleifend mauris. Sed bibendum, mauris sit amet placerat dictum, orci elit commodo lectus, hendrerit varius lectus dui et mauris. Donec ut nunc est. Curabitur interdum justo a ex pellentesque laoreet. Sed blandit sagittis nunc sit amet consequat. Etiam convallis velit non eleifend rhoncus. In tempor iaculis leo, sed molestie est mollis et. Ut et nisl condimentum, luctus velit in, ultrices erat. Maecenas id tortor nec nisl auctor sodales sed in nunc. Integer ultricies mi vitae ante vestibulum vestibulum. Vivamus scelerisque orci nec justo gravida, a ullamcorper mi malesuada. Ut auctor, velit vitae cursus accumsan, turpis mi interdum metus, pellentesque fringilla est quam eu libero. Suspendisse tempor urna velit, mattis convallis massa dapibus sed.\n" +
"\n" +
"Integer convallis laoreet libero in ornare. Maecenas lectus lorem, fringilla at lectus at, imperdiet tristique ipsum. Nulla imperdiet iaculis libero nec tristique. Proin congue sapien sit amet justo luctus placerat. Aliquam vel metus vitae est scelerisque eleifend ac sed velit. Etiam enim massa, consectetur sed euismod eget, sollicitudin vitae lacus. Suspendisse quis massa id sem accumsan condimentum. Cras ac ipsum tellus. Sed convallis fringilla nisl vel blandit. Pellentesque rhoncus luctus ipsum, vel placerat nibh tempus in. Etiam pulvinar lobortis risus id feugiat. Proin quis porttitor sem, vel tempus ipsum. Fusce rutrum, purus congue auctor pretium, leo leo aliquam ante, vel tristique arcu dui at est.");

        BookInformation informacion3 = new BookInformation(3,"La biblia",
                "Diosito","Religion","3335");
        BookNotes nota3 = new BookNotes(3);
        Book libro3 = new Book(informacion3, nota3, 40, false,"opinion 3");


        //Insertar libros en linkedlist
        listaLibros.insertEnd(libro1);
        listaLibros.insertEnd(libro2);
        listaLibros.insertEnd(libro3);
        MyBooks biblioteca = new MyBooks(listaLibros);

        WriteJson writejson = new WriteJson();
        try {
            writejson.createAuxBook(biblioteca.getMyBooks());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadJson readJson = new ReadJson();
        try {
            //List<AuxBook> arrBooks = readJson.readJson();
            MyBooks myBooks = readJson.arrAuxToMyBooks(readJson.readJson());
            
            myBooks.printAllBooks();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //PruebaLombok reducir = new PruebaLombok();





    }
}
