package br.com.senai.fatesg.primefaces.util;

public class ValidaCPF {
	  public boolean isCPF(String cpf){
	        boolean result = false;
	        int[] numerosCpf = new int[11];
	        int quantidadeZeros = 11 - cpf.length();
	        int soma = 0;

	        //validar se existe algum caracter que não seja dígito
	        for(int i = 0; i < cpf.length(); i++){
	            if(!Character.isDigit(cpf.charAt(i))){
	                return result;
	            }
	        }

	        for(int i = 0; i < quantidadeZeros; i++){
	            numerosCpf[i] = 0;
	        }

	        int j = 0;
	        for(int i = quantidadeZeros; i < 11; i++){
	            numerosCpf[i] = Integer.parseInt(cpf.substring(j,j+1));
	            j++;
	        }

	        //valida se a quantidade de dígitos informados é maior de 11
	        if(cpf.length() > 11){
	            return result;
	        }

	        //valida se todos os números são iguais
	        if(numerosCpf[0] == numerosCpf[1] &&
	                numerosCpf[1] == numerosCpf[2] &&
	                numerosCpf[2] == numerosCpf[3] &&
	                numerosCpf[3] == numerosCpf[4] &&
	                numerosCpf[4] == numerosCpf[5] &&
	                numerosCpf[5] == numerosCpf[6] &&
	                numerosCpf[6] == numerosCpf[7] &&
	                numerosCpf[7] == numerosCpf[8] &&
	                numerosCpf[8] == numerosCpf[9] &&
	                numerosCpf[9] == numerosCpf[10]){
	            return result;
	        }

	        //calculo do primeiro dígito
	        for(int i = 0; i < numerosCpf.length-2; i++){
	            soma += numerosCpf[i] * (10-i);
	        }

	        int primeiroDigito = (11-(soma%11));

	        //Cálculo do segundo dígito
	        soma = 0;
	        for(int i = 0; i < numerosCpf.length-1; i++){
	            soma += numerosCpf[i] * (11-i);
	        }

	        int segundoDigito = (11-(soma%11));

	        result = (primeiroDigito == numerosCpf[9]) && (segundoDigito ==  numerosCpf[10]);

	        return result;
	        
	       
	    }
}
