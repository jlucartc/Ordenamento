package Ordenamento;

public class Merge_Sort {

	public static String[] merge(String[] lista1, String[] lista2){
		String[][] lista = new String[2][];
		lista[0] = lista1;
		lista[1] = lista2;
		String[] listafinal;
		if(lista2 != null){
			listafinal = new String[lista1.length+lista2.length];
		}
		else{
			listafinal = new String[lista1.length];
		}

		for(int i = 0; i< lista.length; i++){
			if(lista[i] != null){
				if(lista[i].length % 2 == 0){
					String[] lista_e = new String[lista[i].length/2];
					String[] lista_d = new String[lista[i].length/2];
					for(int j = 0; j<lista[i].length/2; j++){
						lista_e[j] = lista[i][j];
						lista_d[j] = lista[i][j+(lista[i].length/2)];
					}
					lista[i] = merge(lista_e,lista_d);

				}
				else{
					if(lista[i].length != 1){
						String[] lista_e = new String[lista[i].length/2];
						String[] lista_d = new String[lista[i].length-(lista[i].length/2)];
						for(int j = 0; j < lista[i].length; j++){
							if(j < lista[i].length-(lista[i].length/2)-1){
								lista_e[j] = lista[i][j];
							}
							else{
								lista_d[j-(lista[i].length-(lista[i].length/2)-1)] = lista[i][j];
							}	
						}
						lista[i] = merge(lista_e,lista_d);

					}
					else{
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
		int l1 = 0;
		int l2 = 0;
		if(lista2 == null){
			return lista[0];
		}
		else{
			for(int k = 0; k < listafinal.length; k++){
				if(l1 < lista1.length && l2 < lista2.length){
					if(lista[0][l1].compareTo(lista[1][l2]) > 0){
						listafinal[k] = lista[1][l2];
						l2++;
					}
					else{
						listafinal[k] = lista[0][l1];
						l1++;
					}
				}
				else{
					if(l1 >= lista1.length && l2 < lista2.length){
						listafinal[k] = lista[1][l2];
						l2++;
					}
					else{
						listafinal[k] = lista[0][l1];
						l1++;
					}
				}
			}
			return listafinal;
		}
	}

	public static void main(String[] args){
		String[] novo = {"ano","dia","folha","futebol","foto","dado","azul"};
		novo = merge(novo,null);

		for(int i = 0 ; i < novo.length;i++){
			System.out.println(novo[i]);
		}
	}

}
