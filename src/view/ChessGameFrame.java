package view;

import controller.GameController;
import listener.GameListener;
import model.BackgroundMusic;
import model.ChessboardPoint;
import model.Chessboard;
import javax.swing.*;
import java.awt.*;
import view.StartFrame;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    public boolean original;
    private final int HEIGTH;
    private final int ONE_CHESS_SIZE;
    public static JLabel turnlabel=new JLabel();
    public static JLabel playerlabel=new JLabel();
    public static JLabel selectedlabel=new JLabel();
    private ChessboardComponent chessboardComponent;
    private GameController gameController;
    JLabel background;
    public StartFrame startFrame;
    public final JLabel originBG;
    public final JLabel lavaBG;

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
        original=true;


        turnlabel.setText("Turn: 1");
        turnlabel.setLocation(100, 20);
        turnlabel.setSize(200, 60);
        turnlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(turnlabel);
        playerlabel.setText("Player: Blue");
        playerlabel.setLocation(300, 20);
        playerlabel.setSize(200, 60);
        playerlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(playerlabel);
        selectedlabel.setText("Selected: ");
        selectedlabel.setLocation(600, 20);
        selectedlabel.setSize(200, 60);
        selectedlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(selectedlabel);
        addTeamLabel();
        //addLoadButton();
        addRestartButton();
        addChangeColorButton();
        addChangeThemeButton();
        addBackButton();

        Image image = new ImageIcon("resource/background/origin.jpg").getImage();
        image = image.getScaledInstance(1100, 810,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        originBG = new JLabel(icon);
        originBG.setSize(1100, 810);
        originBG.setLocation(0, 0);

        image = new ImageIcon("resource/background/lava.png").getImage();
        image = image.getScaledInstance(1100, 810,Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        lavaBG = new JLabel(icon);
        lavaBG.setSize(1100, 810);
        lavaBG.setLocation(0, 0);

        background = originBG;
        add(background);


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
        chessboardComponent = new ChessboardComponent(ONE_CHESS_SIZE,turnlabel,playerlabel);
        chessboardComponent.setLocation(HEIGTH /5, HEIGTH / 10);
        add(chessboardComponent);
    }


    /**
     * 在游戏面板中添加标签
     */
    private void addTeamLabel() {
        JLabel statusLabel = new JLabel("Team: 鼠鼠游泳");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10-40);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */


    //LOADING THE GAME INFORMATION, NEXT TODO
    private void addChangeThemeButton() {
        JButton button = new JButton("Change Theme");
        button.setLocation(HEIGHT+793, HEIGHT / 10 + 518);
        button.setSize(200,60);
        button.setFont(new Font("Rockwell", Font.BOLD, 16));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click change theme");
            chessboardComponent.changeTheme(original);
            if (original){
                remove(background);
                original = false;
                background = lavaBG;
                add(background);
            } else {
                remove(background);
                original = true;
                background = originBG;
                add(background);
            }
            repaint();
            revalidate();
        });
    }
    private void addBackButton() {
        JButton button = new JButton("Back");
        button.setLocation(HEIGHT+793, HEIGHT / 10 +350);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click back");
            this.setVisible(false);
            startFrame.setVisible(true);
        });
    }


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
           chessboardComponent.getGameController().reset();
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
            String name = (String) JOptionPane.showInputDialog(null, "Which to change?", "Change Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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

    public static JLabel getSelectedlabel() {
        return selectedlabel;
    }
}
