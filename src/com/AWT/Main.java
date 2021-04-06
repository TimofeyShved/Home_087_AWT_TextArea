package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main(){ // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args){
        Main  myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showTextAreaDemo(); // и вызываемый метод showListDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI(){
        mainFrame = new Frame("Java AWT TextArea");  // инициализация фрэйма
        mainFrame.setSize(450,400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener( new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent){ // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350,100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в TextArea
    private void showTextAreaDemo(){
        headerLabel.setText("Контрол в действии: TextArea");

        Label  commentlabel= new Label("Комментарий: ", Label.RIGHT); // метка

        final TextArea commentTextArea = new TextArea("Это текст " // большое текстове поле
                +"нашего комментария",5,30);

        Button showButton = new Button("Показать");  // кнопка

        showButton.addActionListener(new ActionListener() { // действие
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText( "Наш текст - " + commentTextArea.getText()); // статусное окно
            }
        });

        // добавление объектов на форму
        controlPanel.add(commentlabel);
        controlPanel.add(commentTextArea);
        controlPanel.add(showButton);

        // видимость формы true
        mainFrame.setVisible(true);
    }
}
