package view;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;

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
    public static JLabel winlabel=new JLabel();

    private ChessboardComponent chessboardComponent;
    JLabel background;
    public StartFrame startFrame;
    public final JLabel origin;
    public final JLabel lava;

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
        winlabel.setText("Winner: ");
        winlabel.setLocation(850, 10);
        winlabel.setSize(200, 60);
        winlabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(winlabel);

        addTeamLabel();
        addLoadButton();
        addRestartButton();
        addChangeThemeButton();
        addBackButton();
        addSaveButton();
        addTipsButton();

        Image image = new ImageIcon("resource/background/origin.jpg").getImage();
        image = image.getScaledInstance(1100, 810,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        origin = new JLabel(icon);
        origin.setSize(1100, 810);
        origin.setLocation(0, 0);

        image = new ImageIcon("resource/background/lava.png").getImage();
        image = image.getScaledInstance(1100, 810,Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        lava = new JLabel(icon);
        lava.setLocation(0, 0);
        lava.setSize(1100, 810);


        background = origin;
        add(background);



    }

    public ChessboardComponent getChessboardComponent() {
        return chessboardComponent;
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
            chessboardComponent.changeTheme(original);
            if (original){
                remove(background);
                background = lava;
                add(background);
                original = false;
            } else {
                remove(background);
                background = origin;
                add(background);
                original = true;
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
    private void addSaveButton() {
        JButton button = new JButton("Save");
        button.setLocation(HEIGHT+793, HEIGHT / 10 +270);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            chessboardComponent.gameController.saveGameToFile();
        });
    }


    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            String path = "";
            System.out.println("Click load");
            // path = JOptionPane.showInputDialog(this,"Input Path here");
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(Objects.requireNonNull(this.getClass().getResource("/")).getPath()));
            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                path = chooser.getSelectedFile().getName();
            }
            try{
                chessboardComponent.gameController.loadGameFromFile(path);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    private void addRestartButton() {
        JButton button = new JButton("Restart");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(e -> chessboardComponent.getGameController().reset());
    }
    private void addTipsButton() {
        JButton button = new JButton("tips");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this,
                "1.小心对方的陷阱！你可能需要先派出一个先锋排雷？\n" +
                        "2.狮子和老虎才是这片战场上行动能力最强的棋子。\n" +
                        "3.狭路相逢先手胜？\n" +
                        "4.记得留下’护卫‘来保证陷阱发挥作用。\n" +
                        "5.担心被老虎和狮子撕开防线吗？试试用老鼠阻碍进攻吧！\n" +
                        "6.在旁边有老鼠的情况下，即使是大象也不敢轻举妄动哦！\n" +
                        "7.进攻之余，别忘了防御阵线的布置！\n" +
                        "8.遇到困难时，不妨先保存游戏，休息一下吧！"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 50);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    public static JLabel getTurnlabel() {
        return turnlabel;
    }

    public void setTurnlabel(JLabel turnlabel) {
        ChessGameFrame.turnlabel = turnlabel;
    }

    public static JLabel getPlayerlabel() {
        return playerlabel;
    }

    public void setPlayerlabel(JLabel playerlabel) {
        ChessGameFrame.playerlabel = playerlabel;
    }

    public static JLabel getSelectedlabel() {
        return selectedlabel;
    }

    public static JLabel getWinlabel() {
        return winlabel;
    }
    public boolean getOriginal(){
        return original;
    }
}
