package org.example.springdata1.ihm;

import org.apache.catalina.User;
import org.example.springdata1.entity.Author;
import org.example.springdata1.entity.Genre;
import org.example.springdata1.services.AuthorService;
import org.example.springdata1.services.BookService;
import org.example.springdata1.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class IHM implements CommandLineRunner {


    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;


    @Override
    public void run(String... args) throws Exception {
        menu();
        System.exit(0);
    }


    private void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    menuAuthor();
                    break;
                case 2:
                    menupublisher();
                    break;
                case 3:
                    menuGenre();
                    break;
                case 4:
                    menuBook();
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        }while(choice!=0);

    }

    private void displayMenu(){
        System.out.println("Menu principal:");
        System.out.println("1. Gestion Author");
        System.out.println("2. Gestion Publication");
        System.out.println("3. Gestion Genre");
        System.out.println("4. Gestion Book");
        System.out.println("0. Exit");
        System.out.println("Choisissez une option : ");

    }

    private void menuAuthor(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenuAuthor();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    authorService.save(addAuthor());
                    break;
                case 2:
                    afficheAuthors();
                    break;
                case 3:
                    if (afficheAuthors()) {
                        Scanner modif = new Scanner(System.in);
                        System.out.println("Quel autheur modifier : (id)");

                        Long authId = (long) modif.nextInt();
                        System.out.println("Quel nom ?");

                        Scanner nom = new Scanner(System.in);
                        Author newAuthor = new Author();
                        newAuthor.setName(nom.nextLine());
                        authorService.update(authId, newAuthor);
                    }
                    break;
                case 4:
                    if (afficheAuthors()) {
                        Scanner supp = new Scanner(System.in);
                        System.out.println("Quel autheur supprimer : (id)");
                        Long authId = (long) supp.nextInt();
                        authorService.delete(authId);
                    }
                    break;
                case 0:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        }while(choice!=0);
    }

    private void displayMenuAuthor(){
        System.out.println("Gestion Author");
        System.out.println("1. Ajouter un author");
        System.out.println("2. Liste des authors");
        System.out.println("3. Modifier un author");
        System.out.println("4. Supprimer un author");
        System.out.println("0. Retour");
        System.out.println("Choisissez une option : ");
    }

    private Author addAuthor(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom de l'auteur :");
        String nom = scanner.nextLine();

        Author author = new Author();
        author.setName(nom);

        return author;
    }

    private boolean afficheAuthors(){
        List<Author> listeAuthor = authorService.findAll();
        if(listeAuthor.isEmpty()){
            System.out.println("Aucun author existant");
            return false;
        }else {
            for(Author author : listeAuthor){
                System.out.println(author);
            }
            return true;
        }
    }

    private void menuGenre(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenuGenre();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Ajouter");
                    break;
                case 2:
                    List<Genre> listeGenre = genreService.findAll();
                    if(listeGenre.isEmpty()){
                        System.out.println("Aucun author existant");
                    }else {
                        for(Genre genre : listeGenre){
                            System.out.println(genre);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Modifier");
                    break;
                case 4:
                    System.out.println("Supprimer");
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("\n");
            }

        }while(choice!=0);
    }

    private void displayMenuGenre(){
        System.out.println("Gestion Genre");
        System.out.println("1. Ajouter un genre");
        System.out.println("2. Liste des genre");
        System.out.println("3. Modifier un genre");
        System.out.println("4. Supprimer un genre");
        System.out.println("0. Retour");
        System.out.println("Choisissez une option : ");
    }

    private void menupublisher(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenuPublisher();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Ajouter");
                    break;
                case 2:
                    System.out.println("Liste");
                    break;
                case 3:
                    System.out.println("Modifier");
                    break;
                case 4:
                    System.out.println("Supprimer");
                    break;
                case 0:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        }while(choice!=0);
    }

    private void displayMenuPublisher(){
        System.out.println("Gestion Publisher");
        System.out.println("1. Ajouter un publisher");
        System.out.println("2. Liste des publisher");
        System.out.println("3. Modifier un publisher");
        System.out.println("4. Supprimer un publisher");
        System.out.println("0. Retour");
        System.out.println("Choisissez une option : ");
    }

    private void menuBook(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenuBook();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Ajouter");
                    break;
                case 2:
                    System.out.println("Liste");
                    break;
                case 3:
                    System.out.println("Modifier");
                    break;
                case 4:
                    System.out.println("Supprimer");
                    break;
                case 0:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        }while(choice!=0);
    }

    private void displayMenuBook(){
        System.out.println("Gestion Book");
        System.out.println("1. Ajouter un book");
        System.out.println("2. Liste des books");
        System.out.println("3. Modifier un book");
        System.out.println("4. Supprimer un book");
        System.out.println("0. Retour");
        System.out.println("Choisissez une option : ");
    }

}
