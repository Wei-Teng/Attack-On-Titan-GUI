package com.example.worldoftitan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;

public class MarleyWordController implements Initializable {

    @FXML
    private TextArea marleyTextArea;

    @FXML
    private TextArea paradisTextArea;

    @FXML
    private TextArea decryptedTextArea;

    @FXML
    private TextArea encryptedTextArea_1;

    @FXML
    private TextArea encryptedTextArea_2;

    @FXML
    private TextArea originalTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void backToMain(MouseEvent event) {
        ViewInteractor.openScene("start.fxml");
    }

    @FXML
    void convert(MouseEvent event) {
        String paradisWord = convertToParadis(marleyTextArea.getText());
        paradisTextArea.setText(paradisWord);

    }

    @FXML
    void encryptButton(ActionEvent event) {
        MarleyCipher cipher = new MarleyCipher();
        String key = "Cipher Key"; //Just type any string will do
        String encryptedText = cipher.encrypt(originalTextArea.getText(), key);
        encryptedTextArea_1.setText(encryptedText);

    }

    @FXML
    void decryptButton(ActionEvent event) {
        MarleyCipher cipher = new MarleyCipher();
        String key = "Cipher Key"; //Just type any string will do
//        String encryptedText = cipher.encrypt(encryptedTextArea_2.getText(), key);
        String decryptedText = cipher.decrypt(encryptedTextArea_2.getText(), key);
        decryptedTextArea.setText(decryptedText);

    }



    private String convertToParadis(String line){
        AotHashMap<java.lang.Character,java.lang.Character> marley = new AotHashMap<>();
        marley.put('a','j');
        marley.put('b','c');
        marley.put('c','t');
        marley.put('d','a');
        marley.put('e','k');
        marley.put('f','z');
        marley.put('g','s');
        marley.put('h','i');
        marley.put('i','w');
        marley.put('j','x');
        marley.put('k','o');
        marley.put('l','n');
        marley.put('m','g');
        marley.put('n','b');
        marley.put('o','f');
        marley.put('p','h');
        marley.put('q','l');
        marley.put('r','d');
        marley.put('s','e');
        marley.put('t','y');
        marley.put('u','m');
        marley.put('v','v');
        marley.put('w','u');
        marley.put('x','p');
        marley.put('y','q');
        marley.put('z','r');
        marley.put('$',' ');
        marley.put(',',',');

        char[] ch = line.toCharArray();
        StringBuilder converted = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            if(ch[i]=='('){
                Stack<java.lang.Character> stack = new Stack<>();
                StringBuilder invert = new StringBuilder();
                while(ch[++i]!=')'){
                    if(ch[i]=='^'){
                        stack.push(java.lang.Character.toUpperCase(marley.getValue(ch[++i])));
                    }
                    else{
                        stack.push(marley.getValue(ch[i]));
                    }
                }
                while(!stack.isEmpty()){
                    invert.append(stack.pop());
                }
                converted.append(invert);
            }
            else if(ch[i]=='^'){
                converted.append(java.lang.Character.toUpperCase(marley.getValue(ch[++i])));
            }
            else{
                converted.append(marley.getValue(ch[i]));
            }
        }
        return String.valueOf(converted);
    }

}

class MarleyCipher {
    public MarleyCipher() {}

    public String encrypt(String originalText, String key){
        StringBuilder encryptedText = new StringBuilder();
        String upperKey = key.toUpperCase().strip();
        char[] ch = originalText.toCharArray();
        char[] keyList = upperKey.toCharArray();
        for(int i = 0; i < originalText.length(); i++){
            if(java.lang.Character.isAlphabetic(ch[i])) ch[i] = java.lang.Character.toUpperCase(ch[i]);
        }
        for(int i = 0, j = 0; i < originalText.length(); i++){
            if(java.lang.Character.isAlphabetic(ch[i])){
                encryptedText.append((char) ((ch[i] + keyList[j]) % 26 + 'A'));
                j = ++j % keyList.length;
            }
            else encryptedText.append(ch[i]);
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText, String key){
        StringBuilder decryptedText = new StringBuilder();
        String upperKey = key.toUpperCase().strip();
        char[] ch = encryptedText.toCharArray();
        char[] keyList = upperKey.toCharArray();
        for(int i = 0; i < encryptedText.length(); i++){
            if(java.lang.Character.isAlphabetic(ch[i])) ch[i] = java.lang.Character.toUpperCase(ch[i]);
        }
        for(int i = 0, j = 0; i < encryptedText.length(); i++){
            if(java.lang.Character.isAlphabetic(ch[i])){
                int c = java.lang.Character.toLowerCase(((ch[i] - keyList[j] + 26) % 26 +'A'));
                decryptedText.append((char) c);
                j = ++j % keyList.length;
            }
            else decryptedText.append(ch[i]);
        }
        return decryptedText.toString();
    }
}


class AotHashMap<K,V> {
    private final Node<K,V>[] list;
    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        Node(K key, V value){
            this.key =  key;
            this.value = value;
        }
    }

    public AotHashMap() {
        this.list = (Node<K,V>[]) new Node[1000];
    }

    private int getIndex(K key){
        return Objects.hashCode(key) % list.length;
    }

    public void put(K key, V value){
        int index = getIndex(key);
        Node<K,V> prev = search(index,key);
        if(prev.next == null){
            prev.next = new Node<>(key,value);
        }
        else{
            prev.next.value = value;
        }
    }

    private Node<K,V> search(int index, K key){
        if(list[index] == null){
            return list[index] = new Node<>(null, null);
        }
        Node<K,V> prev = list[index];
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }

    public V getValue(K key){
        int index = getIndex(key);
        Node<K,V> prev = search(index,key);
        return prev.next == null? null : prev.next.value;
    }

    public void remove(K key){
        int index = getIndex(key);
        Node<K,V> prev = search(index,key);

        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }
}
