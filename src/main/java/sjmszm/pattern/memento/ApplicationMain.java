package sjmszm.pattern.memento;

import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String input = scanner.next();
            if(input.equals(":list")) { //用户输入“:list”，程序在命令行中输出内存文本的内容
                System.out.println(inputText.getText());
            } else if(input.equals(":undo")) { //用户输入“:undo”，程序会撤销上一次输入的文本
                InputText snapshot = snapshotHolder.popSnapshot();
                inputText.setText(snapshot.getText());
            } else {
                snapshotHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }
    }

}
