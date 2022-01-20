package examenes.parcial_2020_2021.source;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.iterators.InOrderIterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuessWho {

    private BinaryTree<String> game;
    private List<Position<String>> pos;
    private Iterator<Position<String>> iterator;

    public void loadGame(String path) {
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            game = new LinkedBinaryTree<>();
            pos = new LinkedList<>();
            pos.add(null);
            int lineCount = 1;
            String line = null;
            while((line = bf.readLine()) != null) {
                if(!line.equals("NADA")){
                    if(lineCount == 1){
                        pos.add(game.addRoot(line));
                    }
                    else{
                        int posParent = lineCount/2;
                        Position<String> parent = pos.get(posParent);
                        if (lineCount == posParent*2) {
                            pos.add(game.insertLeft(parent, line));
                        }
                        else{
                            pos.add(game.insertRight(parent, line));
                        }
                    }
                }
                else{
                    pos.add(null);
                }
                lineCount++;
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Initializes an iterator through the game, starting at
    the first question
     */
    public void resetIterator() {
        this.iterator = game.iterator();
    }

    /*
    Returns true if there are more question to be read
    by the iterator, or false otherwise
     */
    public boolean hasMoreQuestions() {
        return iterator.hasNext();
    }

    /*
    Returns the next question to be read from the game
     */
    public String nextQuestion() {
        return iterator.next().getElement();
    }

    /*
    Returns the maximum number of questions (without including the response)
    that can be performed in the game
     */
    public int longestGame() {
        return depth(game.root());
    }

    private int depth(Position<String> node){
        int left = 0;
        int right = 0;
        if(game.hasLeft(node)){
            left = depth(game.left(node));
        }
        if(game.hasRight(node)){
            right = depth(game.right(node));
        }
        return Math.max(left, right)+1;
    }

    /*
    Returns the number of responses stored in this game
     */
    public int responses() {
        int cont = 0;
        Iterator<Position<String>> it = new InOrderIterator<>(game);
        while(it.hasNext()){
            Position<String> node = it.next();
            if(game.isLeaf(node)){
                cont++;
            }
        }
        return cont;
    }

    public String solve(String path) {
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = null;
            Position<String> traversal = game.root();
            while ((line = bf.readLine()) != null) {
                if (line.equals("SI") && game.hasLeft(traversal)) {
                    traversal = game.left(traversal);
                } else if (line.equals("NO") && game.hasRight(traversal)) {
                    traversal = game.right(traversal);
                } else {
                    return "INCORRECTO";
                }
            }
            return traversal.getElement();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "INCORRECTO";
    }

    public String showGame() {
        StringBuilder stb = new StringBuilder("");
        showGameRec(game.root(), 0, stb);
        return stb.toString();
    }

    private void showGameRec(Position<String> pos, int lvl, StringBuilder stb){
        for(int i = 0; i<lvl; i++){
            stb.append("\t");
        }
        stb.append(pos.getElement()).append("\n");
        for(Position<String> p: game.children(pos)){
            showGameRec(p, lvl+1, stb);
        }
    }

}