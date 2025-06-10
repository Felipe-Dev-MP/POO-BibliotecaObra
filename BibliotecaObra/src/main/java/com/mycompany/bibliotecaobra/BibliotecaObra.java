package com.mycompany.bibliotecaobra;

public class BibliotecaObra {

    public static void main(String[] args) {

    Obra livro = new Obra("9783161484100", "O Nome do Vento", "Patrick Rothfuss", 2007, 3);
    Obra livro2 = new Obra("9780451524930", "1984", "George Orwell", 1949, 2);//valor 5 no final para dar certo
    
    System.out.println("Livro 1:");
    if (livro.obraValida()) {
        System.out.println(livro);
        livro.emprestar();
        livro.emprestar();
        livro.emprestar();
        livro.emprestar();
        livro.devolver();
        System.out.println(livro);
    } else {
        System.out.println("Isbn inválido");
    }
    
    System.out.println("Livro 2:");
    if (livro2.obraValida()) {
        System.out.println(livro2);
        livro2.emprestar();
        livro2.emprestar();
        livro2.emprestar();
        livro2.emprestar();
        livro2.devolver();
        System.out.println(livro2);
    } else {
        System.out.println("Isbn Inválido");
    }
}

}
