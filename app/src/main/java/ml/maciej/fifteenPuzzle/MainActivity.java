package ml.maciej.fifteenPuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Random;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button[][] puzzle = new Button[4][4];
    Random rand = new Random();
    Set<Integer> set = new LinkedHashSet<Integer>();

    TextView textView;

    Chronometer chronometer;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);

        puzzle[0][0] = (Button)findViewById(R.id.button);
        puzzle[0][1] = (Button)findViewById(R.id.button2);
        puzzle[0][2] = (Button)findViewById(R.id.button3);
        puzzle[0][3] = (Button)findViewById(R.id.button4);

        puzzle[1][0] = (Button)findViewById(R.id.button5);
        puzzle[1][1] = (Button)findViewById(R.id.button6);
        puzzle[1][2] = (Button)findViewById(R.id.button7);
        puzzle[1][3] = (Button)findViewById(R.id.button8);

        puzzle[2][0] = (Button)findViewById(R.id.button9);
        puzzle[2][1] = (Button)findViewById(R.id.button10);
        puzzle[2][2] = (Button)findViewById(R.id.button11);
        puzzle[2][3] = (Button)findViewById(R.id.button12);

        puzzle[3][0] = (Button)findViewById(R.id.button13);
        puzzle[3][1] = (Button)findViewById(R.id.button14);
        puzzle[3][2] = (Button)findViewById(R.id.button15);
        puzzle[3][3] = (Button)findViewById(R.id.button16);

        textView = (TextView)findViewById(R.id.textView);

        setAllFactoryValues();
        setAllEnabled(false);

    }

    //Directions 1 - UP, 2 - RIGHT, 3 - DOWN, 4 - LEFT
    public void blockCheck(int blockNumber) {
        switch (blockNumber){
            case 16: //[3][3]
                if (puzzle[2][3].getText() == "") blockMove(3,3,1); //if upper block is free
                else if (puzzle[3][2].getText() == "") blockMove(3,3,4); //if left block is free
                break;
            case 15: //[3][2]
                if (puzzle[2][2].getText() == "") blockMove(3,2,1); //if upper block is free
                else if (puzzle[3][3].getText() == "") blockMove(3,2,2); //if right block is free
                else if (puzzle[3][1].getText() == "") blockMove(3,2,4); //if left block is free
                break;
            case 14: //[3][1]
                if (puzzle[2][1].getText() == "") blockMove(3,1,1); //if upper block is free
                else if (puzzle[3][2].getText() == "") blockMove(3,1,2); //if right block is free
                else if (puzzle[3][0].getText() == "") blockMove(3,1,4); //if left block is free
                break;
            case 13: //[3][0]
                if (puzzle[2][0].getText() == "") blockMove(3,0,1); //if upper block is free
                else if (puzzle[3][1].getText() == "") blockMove(3,0,2); //if right block is free
                break;
            case 12: //[2][3]
                if (puzzle[1][3].getText() == "") blockMove(2,3,1); //if upper block is free
                else if (puzzle[3][3].getText() == "") blockMove(2,3,3); //if bottom block is free
                else if (puzzle[2][2].getText() == "") blockMove(2,3,4); //if left block is free
                break;
            case 11: //[2][2]
                if (puzzle[1][2].getText() == "") blockMove(2,2,1); //if upper block is free
                else if (puzzle[2][3].getText() == "") blockMove(2,2,2); //if right block is free
                else if (puzzle[3][2].getText() == "") blockMove(2,2,3); //if bottom block is free
                else if (puzzle[2][1].getText() == "") blockMove(2,2,4); //if left block is free
                break;
            case 10: //[2][1]
                if (puzzle[1][1].getText() == "") blockMove(2,1,1); //if upper block is free
                else if (puzzle[2][2].getText() == "") blockMove(2,1,2); //if right block is free
                else if (puzzle[3][1].getText() == "") blockMove(2,1,3); //if bottom block is free
                else if (puzzle[2][0].getText() == "") blockMove(2,1,4); //if left block is free
                break;
            case 9: //[2][0]
                if (puzzle[1][0].getText() == "") blockMove(2,0,1); //if upper block is free
                else if (puzzle[2][1].getText() == "") blockMove(2,0,2); //if right block is free
                else if (puzzle[3][0].getText() == "") blockMove(2,0,3); //if bottom block is free
                break;
            case 8: //[1][3]
                if (puzzle[0][3].getText() == "") blockMove(1,3,1); //if upper block is free
                else if (puzzle[2][3].getText() == "") blockMove(1,3,3); //if bottom block is free
                else if (puzzle[1][2].getText() == "") blockMove(1,3,4); //if left block is free
                break;
            case 7: //[1][2]
                if (puzzle[0][2].getText() == "") blockMove(1,2,1); //if upper block is free
                else if (puzzle[1][3].getText() == "") blockMove(1,2,2); //if right block is free
                else if (puzzle[2][2].getText() == "") blockMove(1,2,3); //if bottom block is free
                else if (puzzle[1][1].getText() == "") blockMove(1,2,4); //if left block is free
                break;
            case 6: //[1][1]
                if (puzzle[0][1].getText() == "") blockMove(1,1,1); //if upper block is free
                else if (puzzle[1][2].getText() == "") blockMove(1,1,2); //if right block is free
                else if (puzzle[2][1].getText() == "") blockMove(1,1,3); //if bottom block is free
                else if (puzzle[1][0].getText() == "") blockMove(1,1,4); //if left block is free
                break;
            case 5: //[1][3]
                if (puzzle[0][0].getText() == "") blockMove(1,0,1); //if upper block is free
                else if (puzzle[1][1].getText() == "") blockMove(1,0,2); //if right block is free
                else if (puzzle[2][0].getText() == "") blockMove(1,0,3); //if bottom block is free
                break;
            case 4: //[0][3]
                if (puzzle[1][3].getText() == "") blockMove(0,3,3); //if bottom block is free
                else if (puzzle[0][2].getText() == "") blockMove(0,3,4); //if left block is free
                break;
            case 3: //[0][2]
                if (puzzle[0][3].getText() == "") blockMove(0,2,2); //if right block is free
                else if (puzzle[1][2].getText() == "") blockMove(0,2,3); //if bottom block is free
                else if (puzzle[0][1].getText() == "") blockMove(0,2,4); //if left block is free
                break;
            case 2: //[0][1]
                if (puzzle[0][2].getText() == "") blockMove(0,1,2); //if right block is free
                else if (puzzle[1][1].getText() == "") blockMove(0,1,3); //if bottom block is free
                else if (puzzle[0][0].getText() == "") blockMove(0,1,4); //if left block is free
                break;
            case 1: //[0][0]
                if (puzzle[0][1].getText() == "") blockMove(0,0,2); //if right block is free
                else if (puzzle[1][0].getText() == "") blockMove(0,0,3); //if bottom block is free
        }
        if(
                puzzle[0][0].getText().toString().equals("1") &&
                        puzzle[0][1].getText().toString().equals("2") &&
                        puzzle[0][2].getText().toString().equals("3") &&
                        puzzle[0][3].getText().toString().equals("4") &&
                        puzzle[1][0].getText().toString().equals("5") &&
                        puzzle[1][1].getText().toString().equals("6") &&
                        puzzle[1][2].getText().toString().equals("7") &&
                        puzzle[1][3].getText().toString().equals("8") &&
                        puzzle[2][0].getText().toString().equals("9") &&
                        puzzle[2][1].getText().toString().equals("10") &&
                        puzzle[2][2].getText().toString().equals("11") &&
                        puzzle[2][3].getText().toString().equals("12") &&
                        puzzle[3][0].getText().toString().equals("13") &&
                        puzzle[3][1].getText().toString().equals("14") &&
                        puzzle[3][2].getText().toString().equals("15")) {
            chronometer.stop();
            running = false;
            textView.setText("You won!");
            setAllEnabled(false);
        }
    }

    //Directions 1 - UP, 2 - RIGHT, 3 - DOWN, 4 - LEFT
    void blockMove(int y, int x, int kierunek){
        int tmpX, tmpY;
        tmpX=x;
        tmpY=y;
        switch (kierunek){
            case 4:
                tmpX=x-1;
                break;
            case 3:
                tmpY=y+1;
                break;
            case 2:
                tmpX=x+1;
                break;
            case 1:
                tmpY=y-1;
                break;
        }
        puzzle[tmpY][tmpX].setText(puzzle[y][x].getText()); //set free block value of clicked
        puzzle[tmpY][tmpX].setVisibility(View.VISIBLE); //make free block visible
        puzzle[y][x].setText(""); //set clicked block as free
        puzzle[y][x].setVisibility(View.INVISIBLE); //make clicked block invisible
    }

    public void button1(View view) { blockCheck(1); }
    public void button2(View view) { blockCheck(2); }
    public void button3(View view) { blockCheck(3); }
    public void button4(View view) { blockCheck(4); }
    public void button5(View view) { blockCheck(5); }
    public void button6(View view) { blockCheck(6); }
    public void button7(View view) { blockCheck(7); }
    public void button8(View view) { blockCheck(8); }
    public void button9(View view) { blockCheck(9); }
    public void button10(View view) { blockCheck(10); }
    public void button11(View view) { blockCheck(11); }
    public void button12(View view) { blockCheck(12); }
    public void button13(View view) { blockCheck(13); }
    public void button14(View view) { blockCheck(14); }
    public void button15(View view) { blockCheck(15); }
    public void button16(View view) { blockCheck(16); }

    public void newGame(View view) {

        setAllFactoryValues();
        setAllEnabled(true);
        textView.setText("");

        puzzle[0][0].setVisibility(View.VISIBLE);
        puzzle[0][1].setVisibility(View.VISIBLE);
        puzzle[0][2].setVisibility(View.VISIBLE);
        puzzle[0][3].setVisibility(View.VISIBLE);
        puzzle[1][0].setVisibility(View.VISIBLE);
        puzzle[1][1].setVisibility(View.VISIBLE);
        puzzle[1][2].setVisibility(View.VISIBLE);
        puzzle[1][3].setVisibility(View.VISIBLE);
        puzzle[2][0].setVisibility(View.VISIBLE);
        puzzle[2][1].setVisibility(View.VISIBLE);
        puzzle[2][2].setVisibility(View.VISIBLE);
        puzzle[2][3].setVisibility(View.VISIBLE);
        puzzle[3][0].setVisibility(View.VISIBLE);
        puzzle[3][1].setVisibility(View.VISIBLE);
        puzzle[3][2].setVisibility(View.VISIBLE);
        puzzle[3][3].setVisibility(View.INVISIBLE);

        set.clear();
        while (set.size() < 15) {
            set.add(rand.nextInt(15)+1);
        }

        Integer[] intArray = new Integer[set.size()];
        intArray = set.toArray(intArray);

        puzzle[0][0].setText(intArray[0].toString());
        puzzle[0][1].setText(intArray[1].toString());
        puzzle[0][2].setText(intArray[2].toString());
        puzzle[0][3].setText(intArray[3].toString());
        puzzle[1][0].setText(intArray[4].toString());
        puzzle[1][1].setText(intArray[5].toString());
        puzzle[1][2].setText(intArray[6].toString());
        puzzle[1][3].setText(intArray[7].toString());
        puzzle[2][0].setText(intArray[8].toString());
        puzzle[2][1].setText(intArray[9].toString());
        puzzle[2][2].setText(intArray[10].toString());
        puzzle[2][3].setText(intArray[11].toString());
        puzzle[3][0].setText(intArray[12].toString());
        puzzle[3][1].setText(intArray[13].toString());
        puzzle[3][2].setText(intArray[14].toString());

        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        running = true;

    }
    void setAllEnabled(boolean value){
        puzzle[0][0].setEnabled(value);
        puzzle[0][1].setEnabled(value);
        puzzle[0][2].setEnabled(value);
        puzzle[0][3].setEnabled(value);
        puzzle[1][0].setEnabled(value);
        puzzle[1][1].setEnabled(value);
        puzzle[1][2].setEnabled(value);
        puzzle[1][3].setEnabled(value);
        puzzle[2][0].setEnabled(value);
        puzzle[2][1].setEnabled(value);
        puzzle[2][2].setEnabled(value);
        puzzle[2][3].setEnabled(value);
        puzzle[2][3].setEnabled(value);
        puzzle[3][0].setEnabled(value);
        puzzle[3][1].setEnabled(value);
        puzzle[3][2].setEnabled(value);
        puzzle[3][3].setEnabled(value);
    }
    void setAllFactoryValues(){
        puzzle[0][0].setText("1");
        puzzle[0][1].setText("2");
        puzzle[0][2].setText("3");
        puzzle[0][3].setText("4");
        puzzle[1][0].setText("5");
        puzzle[1][1].setText("6");
        puzzle[1][2].setText("7");
        puzzle[1][3].setText("8");
        puzzle[2][0].setText("9");
        puzzle[2][1].setText("10");
        puzzle[2][2].setText("11");
        puzzle[2][3].setText("12");
        puzzle[3][0].setText("13");
        puzzle[3][1].setText("14");
        puzzle[3][2].setText("15");
        puzzle[3][3].setText("");
    }
}