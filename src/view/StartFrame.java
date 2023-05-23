package view;

import controller.GameController;
import model.BackgroundMusic;
import model.Chessboard;
import view.ChessGameFrame;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame{
    private final int WIDTH;
    private final int HEIGTH;

    private final int ONE_CHESS_SIZE;
    private ChessGameFrame gameFrame;
    private ChessboardComponent chessboardComponent;
    private GameController gameController;
    public StartFrame(int width, int height) {
        setTitle("斗兽棋"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(new BorderLayout());
        addBeginButton();
        addRuleButton();

        Image image = new ImageIcon("resource/background/start1.jpg").getImage();
        image = image.getScaledInstance(400, 500,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JLabel bg = new JLabel(icon);
        bg.setSize(400, 500);
        bg.setLocation(0, 0);
        add(bg);
    }
    private void addRuleButton() {
        JButton button = new JButton("Show Rules Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this,
                "象、狮、虎、豹、犬、狼、猫、鼠。较大的可吃较小的，同类可以互吃，而鼠则可吃象，象不能吃鼠。动物走一格，前后左右都可以。" +
                        "如果一方进入了对方的兽穴便胜出。任何一方都不能进入自己的兽穴。\n" +
                        "如果对方的兽类走进陷阱，己方任何一只兽都可以把它吃掉，如果敌兽进入陷阱，一回合后，自己的兽类不吃掉陷阱中的敌兽，当对方进入己方兽穴时，则本方输。\n" +
                        "中间有两条小河（跟湖差不多）。" +
                        "狮、虎可以横直方向跳过河，而且可以直接把对岸的动物吃掉。只有鼠可以下水，在水中的鼠可以阻隔狮、虎跳河。两鼠在水内可以互吃。"));        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(240, 80);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setLocation(200,100);
        add(button);
    }
    private void addBeginButton() {
        JButton button = new JButton("Begin");
        button.addActionListener((e) -> {
            ChessGameFrame mainFrame = new ChessGameFrame(1100, 800);
            GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard());
            mainFrame.setVisible(true);
            this.gameFrame=mainFrame;
            gameFrame.startFrame=this;
            new BackgroundMusic().playMusic("resource\\music\\blues.wav");
        });
        button.setSize(240,80);
        button.setLocation(200,300);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }
}