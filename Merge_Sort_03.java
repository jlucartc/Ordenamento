package Ordenamento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Merge_Sort_03 {

	public static int[] merge(int[] lista){
		int[] esquerda = new int[lista.length/2];				// Sublista 1
		int[] direita = new int[lista.length-esquerda.length];	// Sublista 2
		
		if(lista.length != 1){
		for(int i = 0; i < lista.length; i++){				//
			if(i < lista.length/2){							//
				esquerda[i] = lista[i];						//	Elementos da lista principal
			}												//	são colocados nas sublistas
			else{											//
				direita[i-(lista.length/2)] = lista[i];		//
			}												//
		}													//
			esquerda = merge(esquerda);
			direita = merge(direita);
		}else{
			return lista;
		}	
		int indice_esquerda = 0;
		int indice_direita = 0;
		for(int i = 0; i< lista.length; i++ ){
			if(indice_esquerda < esquerda.length && indice_direita < direita.length){
				if(esquerda[indice_esquerda] > direita[indice_direita]){
					lista[i] = direita[indice_direita];
					indice_direita++;
				}
				else{
					lista[i] = esquerda[indice_esquerda];
					indice_esquerda++;
				}
			}
			else{
				if(indice_esquerda < esquerda.length){
					lista[i] = esquerda[indice_esquerda];
					indice_esquerda++;
				}
				else{
					lista[i] = direita[indice_direita];
					indice_direita++;
				}
			}
		}
		return lista;
	}

	public static void main(String[] args){
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de entradas: "));
		int[] inteiro = new int[n];
		for(int k = 0; k < n; k++){
			inteiro[k] = n-k;
		}
		long inicio = System.currentTimeMillis(); 
		inteiro = merge(inteiro);
		long fim = System.currentTimeMillis();
		/*
		String temp = "";
		for(int i : inteiro){
			temp+= " "+i;
		}
		System.out.println("Lista ordenada: "+temp+"\n\n");
		System.out.println("\n\n");*/
		System.out.println("Quantidade de entradas: "+n+"\n");
		System.out.println("Tempo decorrido: "+ (fim-inicio)+ " milisegundos");
	}
}
