package view;

import controller.GameController;
import listener.GameListener;
import model.ChessboardPoint;
import model.Chessboard;
import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    private final int ONE_CHESS_SIZE;
    public static JLabel turnlabel=new JLabel();
    public static JLabel playerlabel=new JLabel();
    private ChessboardComponent chessboardComponent;
    private GameController gameController;
    public ChessGameFrame(int width, int height) {
        setTitle("斗兽棋"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;
        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
        addChessboard();


        turnlabel.setText("Turn: 1");
        turnlabel.setLocation(HEIGTH, HEIGTH / 6);
        turnlabel.setSize(200, 60);
        turnlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(turnlabel);
        playerlabel.setText("Player: Blue");
        playerlabel.setLocation(HEIGTH, HEIGTH / 3);
        playerlabel.setSize(200, 60);
        playerlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(playerlabel);
        addTeamLabel();
        addRuleButton();
        addLoadButton();
       // addRestartButton();
        addChangeColorButton();
    }

    public ChessboardComponent getChessboardComponent() {
        return chessboardComponent;
    }

    public void setChessboardComponent(ChessboardComponent chessboardComponent) {
        this.chessboardComponent = chessboardComponent;
    }

    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        chessboardComponent = new ChessboardComponent(ONE_CHESS_SIZE);
        chessboardComponent.setLocation(HEIGTH /5, HEIGTH / 10);
        add(chessboardComponent);
    }

    /**
     * 在游戏面板中添加标签
     */
    private void addTeamLabel() {
        JLabel statusLabel = new JLabel("Team: 鼠鼠游泳");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addRuleButton() {
        JButton button = new JButton("Show Rules Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this,
                "象、狮、虎、豹、犬、狼、猫、鼠。较大的可吃较小的，同类可以互吃，而鼠则可吃象，象不能吃鼠。动物走一格，前后左右都可以。" +
                        "如果一方进入了对方的兽穴便胜出。任何一方都不能进入自己的兽穴。\n" +
                        "如果对方的兽类走进陷阱，己方任何一只兽都可以把它吃掉，如果敌兽进入陷阱，一回合后，自己的兽类不吃掉陷阱中的敌兽，当对方进入己方兽穴时，则本方输。\n" +
                        "中间有两条小河（跟湖差不多）。" +
                        "狮、虎可以横直方向跳过河，而且可以直接把对岸的动物吃掉。只有鼠可以下水，在水中的鼠可以阻隔狮、虎跳河。两鼠在水内可以互吃。"));        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }
    //LOADING THE GAME INFORMATION, NEXT TODO
    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this,"Input Path here");
            GameController.loadGameFromFile(path);
        });
    }
    private void addRestartButton() {
        JButton button = new JButton("Restart");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(e -> {
            //不能用注册了的gamecontroller来用，为什么？
           // gameController.reset();
        });
    }
    private void addChangeColorButton() {
        JButton button = new JButton("Change Color");
        button.setLocation(HEIGHT+793, HEIGHT / 10+600 );
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click change Color");
            Object[] options = {"Grass", "River", "Trap", "Home"};
            String name = (String) JOptionPane.showInputDialog(null, "Which to change?",
                    "Change Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (name == null){
            }else{
                ColorFrame colorFrame = new ColorFrame(name);
                colorFrame.gameFrame = this;
            }
        });
    }
    public static JLabel getTurnlabel() {
        return turnlabel;
    }

    public void setTurnlabel(JLabel turnlabel) {
        this.turnlabel = turnlabel;
    }

    public static JLabel getPlayerlabel() {
        return playerlabel;
    }

    public void setPlayerlabel(JLabel playerlabel) {
        this.playerlabel = playerlabel;
    }

}
