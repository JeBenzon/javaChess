import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board() {

    }

    public void startGame(){
        System.out.println("New Game has started");
        System.out.println("         ,....,\n" +
                "      ,::::::<\n" +
                "     ,::/^\\\"``.\n" +
                "    ,::/, `   e`.\n" +
                "   ,::; |        '.\n" +
                "   ,::|  \\___,-.  c)\n" +
                "   ;::|     \\   '-'\n" +
                "   ;::|      \\\n" +
                "   ;::|   _.=`\\\n" +
                "   `;:|.=` _.=`\\\n" +
                "     '|_.=`   __\\\n" +
                "     `\\_..==`` /\n" +
                "      .'.___.-'.\n" +
                "     /          \\\n" +
                "    ('--......--')\n" +
                "    /'--......--'\\\n" +
                "    `\"--......--\"");

        Piece emptyPiece = new Piece("", "", " ");
        for(int i = 0; i<8; i++){
            for(int j = 0; j < 8; j++){
                setBoard(i, j, emptyPiece);
            }
        }
        //White team
        Piece whiteKing = new Piece("white", "King", "K");
        setBoard(0, 4, whiteKing);
        Piece whiteQueen = new Piece("white", "Queen", "D");
        setBoard(0, 3, whiteQueen);
        Piece whiteBishop = new Piece("white", "Bishop", "L");
        setBoard(0, 2, whiteBishop);
        setBoard(0, 5, whiteBishop);
        Piece whiteKnight = new Piece("white", "Knight", "H");
        setBoard(0, 1, whiteKnight);
        setBoard(0, 6, whiteKnight);
        Piece whiteRook = new Piece("white", "Rook", "T");
        setBoard(0, 0, whiteRook);
        setBoard(0, 7, whiteRook);
        Piece whitePawn = new Piece("white", "Pawn", "B");
        for (int i = 0; i < 8; i++) {
            setBoard(1, i, whitePawn);
        }

        //Black team
        Piece blackKing = new Piece("black", "King", "K");
        setBoard(7, 4, blackKing);
        Piece blackQueen = new Piece("black", "Queen", "D");
        setBoard(7, 3, blackQueen);
        Piece blackBishop = new Piece("black", "Bishop", "L");
        setBoard(7, 2, blackBishop);
        setBoard(7, 5, blackBishop);
        Piece blackKnight = new Piece("black", "Knight", "H");
        setBoard(7, 1, blackKnight);
        setBoard(7, 6, blackKnight);
        Piece blackRook = new Piece("black", "Rook", "T");
        setBoard(7, 0, blackRook);
        setBoard(7, 7, blackRook);
        Piece blackPawn = new Piece("black", "Pawn", "B");
        for (int i = 0; i < 8; i++) {
            setBoard(6, i, blackPawn);
        }

    }

    public String printBoard(){
        String chessBoard = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getType().equals(" ")){
                    chessBoard = chessBoard + " ";
                }else {
                    chessBoard = chessBoard + board[i][j].getType();
                }
                chessBoard = chessBoard + " ";
            }
            chessBoard = chessBoard + "\n";
        }
        return chessBoard;
    }

    public boolean move(int x1, int y1, int x2, int y2){
        setBoard(x2, y2, getPieceOnPosition(x1,y1));
        Piece emptyPiece = new Piece("", "", " ");
        setBoard(x1,y1, emptyPiece);
        return true;
    }

    public boolean moveQueen(int x1, int y1, int x2, int y2){
        return true;
    }

    public void setBoard(int x, int y, Piece piece) {
        this.board[x][y] = piece;
    }

    public Piece getPieceOnPosition(int x, int y) {
        return board[x][y];
    }

    public Piece[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }

    public static void main(String[] args) {
        Scanner position = new Scanner(System.in);  // Create a Scanner object
        Board board = new Board();
        board.startGame();
        boolean gameState = true;
        while (gameState){

            System.out.println(board.printBoard());
            System.out.println("White's turn. - Make a move!");
            System.out.println("From X1 Y1 to X2 Y2 position in this format: X1 Y1 X2 Y2:");
            int x1, y1, x2, y2 = 0;
            x1 = position.nextInt();
            y1 = position.nextInt();
            x2 = position.nextInt();
            y2 = position.nextInt();
            board.move(x1, y1, x2, y2);


            System.out.println(board.printBoard());
            System.out.println("Black's turn. - Make a move!");
            System.out.println("From X1 Y1 to X2 Y2 position in this format: X1 Y1 X2 Y2:");
            x1 = position.nextInt();
            y1 = position.nextInt();
            x2 = position.nextInt();
            y2 = position.nextInt();
            board.move(x1, y1, x2, y2);


        }




    }
}
