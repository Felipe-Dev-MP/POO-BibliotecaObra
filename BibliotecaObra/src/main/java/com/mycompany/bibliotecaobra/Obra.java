package com.mycompany.bibliotecaobra;

import java.time.Year;

public class Obra {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadeDisponivel;
    private boolean obraValida = false;

    public Obra(String isbn, String titulo, String autor, int anoPublicacao, int quantidadeDisponivel){
        if (!validarISBN13(isbn)){
            System.out.println("ISBN invalido.");
            return;
        }
        if (titulo == null || titulo.isEmpty()){
            System.out.println("Título invalido.");
            return;
        }
        if (autor == null || autor.isEmpty()){
            System.out.println("Autor invalido.");
            return;
        }
        
        int anoAtual = Year.now().getValue();
        if (anoPublicacao <= 0 || anoPublicacao > anoAtual){
            System.out.println("Ano de publicação inválido.");
            return;
        }
        if (quantidadeDisponivel < 0){
            System.out.println("Quantidade de exemplares invalida.");
            return;
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.obraValida = true;
    }
    
    public boolean obraValida() {
        return obraValida;
    }
   
    //private pois é usado apenas por outra função 
    private boolean validarISBN13(String isbn){
        /*validar se não é nulo garantir que tenha os 13 digitos e que não tenha
        hifen*/
        if (isbn == null || isbn.length() != 13 || !isbn.matches("\\d{13}")){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            //pega a posição na string e transforma para numero
            int digito = Character.getNumericValue(isbn.charAt(i));
            //alterna em impa e par para multiplicar por 1 ou 3
            if(i% 2 == 0){
                soma+=digito;
            }else{
                soma+= digito*3;
            }
        }
        
        int resto = soma % 10;//para achar o valor para calcular o 13 valor
        int verificador;
        
        if(resto == 0){
            verificador = 0;
        }else{
            verificador = 10-resto;
        }
        
        //compara com o 13 digito
        return verificador == Character.getNumericValue(isbn.charAt(12));
    }

    public void emprestar() {
        if (quantidadeDisponivel <= 0) {
            System.out.println("Nenhum exemplar disponivel para emprestimo.");
        } else {
            quantidadeDisponivel--;
            System.out.println("Emprestimo realizado.");
        }
    }

    public void devolver() {
        quantidadeDisponivel++;
        System.out.println("Devolucao realizada.");
    }
    
    @Override
    public String toString() {
        return "Obra: " + titulo + " | Autor: " + autor + " | Ano: " + anoPublicacao +
               " | ISBN: " + isbn + " | Disponiveis: " + quantidadeDisponivel;
    }
}

