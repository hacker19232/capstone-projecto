import processing.pdf.*;
import java.util.ArrayList;

public class PuzzleBoard {
	
	private ArrayList<PuzzlePiece> board;
	private ArrayList<PuzzlePiece> piecesLeft;
	private ArrayList<Area2D> pieceAreas;
	private PImage imageBoard;
	private boolean isDone;
	private int numPieces;
	private float rectWidth, rectHeight, rectWidth2, rectHeight2;
	
	
	public PuzzleBoard(ArrayList<Area2D> pieceAreas, PImage image, int width, int height, float rectWidth, float rectHeight, float rectWidth2, float rectHeight2) {
		this.numPieces = width*height;
		this.board = setBoard(width, height);
		this.piecesLeft = new ArrayList<PuzzlePiece>(numPieces);
		this.rectWidth = rectWidth;
		this.rectWidth2 = rectWidth2;
		this.rectHeight = rectHeight;
		this.rectHeight2 = rectHeight2;
		this.imageBoard = image;
		this.pieceAreas = pieceAreas;
		
	}
	
	public ArrayList<PuzzlePiece> setBoard(int width, int height) {
		board = new ArrayList<PuzzlePiece, PuzzlePiece>(width, height);
		int count = 0;
		for (int i = 0; i < board.size(); i++) {
			for (int z = 0; z < board.get(0).size(); z++) {
				board[i][z] = count;
				count ++;
			}
		}
		return board;
	}
	
	public String toString() {
		
		for (int i = 0; i < board.size(); i++) {
			for (int z = 0; z < board.get(0).size(); z++) {
				System.out.print(board[i][z]);
			}
			System.out.println();
		}
	
	}
	
	public void displayBoard(PApplet marker) {
		
		marker.pushMatrix();
		marker.imageMode(marker.CENTER);
		
		marker.image(puzzleImage,getRectWidth(),getRectHeight(),getRectWidth2(),getRectHeight2());
        marker.popMatrix();
	}
	
	public void addPiece(PuzzlePiece piece, PImage pieceImage, PApplet marker, Area2D area) {
		
		if (!this.isValidPiece(piece)) {
			return;
		}
		
		imageBoard.beginDraw();
		imageBoard.image(pieceImage, piece.getCorrectLocX(), piece.getCorrectLocY());
		imageBoard.endDraw();
		
		marker.image(imageBoard, 0, 0);
		
		piecesLeft.remove(piece);
		
	}
	
	private boolean isValidPiece(PuzzlePiece piece) {
		return true;
	}
	
	public double amountDone() {
		return 100 * (double)(numPieces-piecesLeft.size())/numPieces;
	}
	
	public float getRectWidth() { return rectWidth; }
    public float getRectHeight() { return rectHeight; }
    public float getRectWidth2() { return rectWidth2; }
    public float getRectHeight2() { return rectHeight2; }
	
	
	
}
