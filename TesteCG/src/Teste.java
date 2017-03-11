/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author priscila
 */
import java.io.*;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        
         /*Instancia um objeto da classe BufferedReader que fornece a função readline, inReader retorna uma linha lida da entrada*/
        BufferedReader	inReader;
        inReader = new BufferedReader(new InputStreamReader(System.in));
        String line; /*linha de string*/
        String name; /*nome usado nos comandos*/
        float x,y,z,ang; /*(x,y,z)eixos, (x,y,z)rgb, x(k-coef. de reflexão), ang(ângulo)*/
        Scanner entrada = new Scanner(System.in); /*usada para ler os floats*/
        
        try {
            System.out.println("Digite seu comando");
            
            /*Leitura dos comandos por linha de comando*/
            /*Irá ler ate não haver mais nada na entrada*/
            while((line = inReader.readLine())!= null) {
                StringTokenizer st = new StringTokenizer(line);
                switch(st.nextToken()){
                    
                    /*Adiciona a forma correspondente de tamanho centrada na origem com o nome name1 a cena*/
                    case "add_shape":
                        switch(st.nextToken()){
                            /*Formas*/
                            case "cube":
                                System.out.println("cube");
                                break;
                            case "sphere":
                                System.out.println("sphere");
                                break;
                            case "cone":
                                System.out.println("cone");
                                break;
                            case "torus":
                                System.out.println("torus");
                                break;
                            default:
                                System.out.printf("Você digitou uma entrada inválida.");
                        }
                    break;
                    
                    /*Remove a forma com o nome name1 da cena*/
                    case "remove_shape":
                        name = st.nextToken();
                        break;
                        
                    /*Adiciona uma nova luz na posição(x,y,z) na cena. Máximo 10*/
                    case "add_light":
                        name = st.nextToken();
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        //System.out.println("a:"+x+" b:"+y+" c:"+z);
                        break;
                        
                    /*Remove a luz com o nome name1 da cena*/    
                    case "remove_light":
                        name = st.nextToken();
                        break;
                        
                    /*Habilita o tipo de reflexão da luz nos objetos da cena e define o coeficiente de reflexão associado (k).
                      Coeficiente  de  brilho  da  reflexão  especular  fixo*/
                    case "reflection_on":
                        switch(st.nextToken()){
                            /*x = (k - coef. de reflexão)*/
                            /*Tipos de reflexão*/
                            case "specular":
                                System.out.println("specular");
                                x = Float.parseFloat(st.nextToken());
                                break;
                            case "diffuse":
                                System.out.println("diffuse");
                                x = Float.parseFloat(st.nextToken());
                                break;
                            case "ambiente":
                                System.out.println("ambient");
                                x = Float.parseFloat(st.nextToken());
                                break;
                            default:
                                System.out.printf("Você digitou uma reflexão inválida.");
                        }
                    break;
                        
                    /*Desabilita o tipo de reflexão da luz nos objetos da cena*/
                    case "reflection_off":
                        switch(st.nextToken()){
                            /*Tipos de reflexão*/
                            case "specular":
                                System.out.println("specular");
                                break;
                            case "diffuse":
                                System.out.println("diffuse");
                                break;
                            case "ambiente":
                                System.out.println("ambient");
                                break;
                            default:
                                System.out.printf("Você digitou uma reflexão inválida.");
                        }
                    break;
                        
                    /*Define o tipo de shading usado para renderizar a cena*/
                    case "shading":
                        switch(st.nextToken()){
                            /*Tipos de shading*/
                            case "flat":
                                System.out.println("flat");
                                break;
                            case "smooth":
                                System.out.println("smooth");
                                break;
                            case "ephong":
                                System.out.println("ephong");
                                break;
                            default:
                                System.out.printf("Você digitou uma reflexão inválida.");
                        }
                    break;
                    
                    /*Define o tipo de projeção.Tamanho do frustum fixo*/
                    case "projection":
                        switch(st.nextToken()){
                            /*Tipos*/
                            case "ortho":
                                System.out.println("ortho");
                                break;
                            case "perspective":
                                System.out.println("perspective");
                                break;
                            default:
                                System.out.printf("Você digitou uma reflexão inválida.");
                        }
                    break;
                    
                    /*Translada a forma correspondente de acordo com os três parâmetros em (x, y, z)*/
                    case "translate":  
                        name = st.nextToken();
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Redimensiona a forma correspondente de acordo com os três parâmetros em (x, y, z)*/    
                    case "scale":
                        name = st.nextToken();
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Rotaciona a forma correspondente de acordo com o ângulo e o vetor (x, y, z)*/    
                    case "rotate":
                        name = st.nextToken();
                        ang = Float.parseFloat(st.nextToken());
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Faz a câmera olhar para o ponto definido pelos parâmetros (x,y,z).*/    
                    case "lookate":
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Define a posição da câmera por meio dos parâmetros (x,y,z)*/    
                    case "cam":
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Define a cor da forma com nome name1 usando três parâmetros (r, g, b).*/    
                    case "color":
                        /*(x,y,z) = rgb*/
                        name = st.nextToken();
                        x = Float.parseFloat(st.nextToken());
                        y = Float.parseFloat(st.nextToken());
                        z = Float.parseFloat(st.nextToken());
                        break;
                        
                    /*Mostra ou esconde os eixos x, y e z. Eixo x vermelho, y verde e z azul*/    
                    case "axis":
                        break;
                        
                    /*Salva a visualização corrente em uma imagem png com o nome filename*/    
                    case "save":
                        name = st.nextToken();
                        break;
                        
                    /*Sai do programa*/    
                    case "quit":
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.printf("Você digitou uma operação inválida.");
                        
                }
            }
            inReader.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}