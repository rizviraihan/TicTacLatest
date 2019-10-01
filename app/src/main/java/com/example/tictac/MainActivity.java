package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int playerOneResult = 0;
    int playerTwoResult = 0;
    boolean isWin = false;
    private int mItemBGColor = Color.parseColor("#FF7398F4");

    String[] boardData = new String[]{
            "-", "-", "-",
            "-", "-", "-",
            "-", "-", "-"};

    List<String> numberList = new ArrayList<>(Arrays.asList(boardData));

    GridView gridView;
    TextView player0Result, player1Result, resultScore;
    Button resetButton;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ColorDrawable[] colors = {
                new ColorDrawable(Color.GREEN), // Animation starting color
                new ColorDrawable(mItemBGColor) // Animation ending color
        };

        gridView = (GridView) findViewById(R.id.gridview);
        player0Result = (TextView) findViewById(R.id.player0result);
        player1Result = (TextView) findViewById(R.id.player1result);
        resultScore = (TextView) findViewById(R.id.result);
        resetButton = (Button) findViewById(R.id.resetButton);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numberList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv_cell = (TextView) super.getView(position, convertView, parent);
                tv_cell.setBackgroundColor(mItemBGColor);
                tv_cell.setGravity(Gravity.CENTER);
                return tv_cell;
            }

        };

        gridView.setAdapter(adapter);
        resetButton.setEnabled(false);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (numberList.get(position).equals("-")) {
                    numberList.set(position, "0");
                    /////////////////////////////AI
                    if (numberList.get(0).equals("X") && numberList.get(1).equals("X") || numberList.get(0).equals("0") && numberList.get(1).equals("0")) {
                        if (numberList.get(2).equals("-")) {
                            numberList.set(2, "X");

                        } else if (numberList.get(2).equals("X") && numberList.get(4).equals("X") || numberList.get(2).equals("0") && numberList.get(4).equals("0")) {
                            if (numberList.get(6).equals("-")) {
                                numberList.set(6, "X");
                            } else {
                                fillUp();
                            }
                        } else if (numberList.get(2).equals("X") && numberList.get(6).equals("X") || numberList.get(2).equals("0") && numberList.get(6).equals("0")) {
                            if (numberList.get(4).equals("-")) {
                                numberList.set(4, "X");
                            } else {
                                fillUp();
                            }
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(3).equals("X") && numberList.get(6).equals("X") || numberList.get(8).equals("X") && numberList.get(4).equals("X")
                            || numberList.get(1).equals("X") && numberList.get(2).equals("X") || numberList.get(3).equals("0") && numberList.get(6).equals("0")
                            || numberList.get(8).equals("0") && numberList.get(4).equals("0") || numberList.get(1).equals("0") && numberList.get(2).equals("0")) {
                        if (numberList.get(0).equals("-")) {
                            numberList.set(0, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(0).equals("X") && numberList.get(2).equals("X") || numberList.get(4).equals("X") && numberList.get(7).equals("X")
                            || numberList.get(0).equals("0") && numberList.get(2).equals("0") || numberList.get(4).equals("0") && numberList.get(7).equals("0")) {
                        if (numberList.get(1).equals("-")) {
                            numberList.set(1, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(5).equals("X") && numberList.get(8).equals("X") || numberList.get(6).equals("X") && numberList.get(4).equals("X")
                            || numberList.get(5).equals("0") && numberList.get(8).equals("0") || numberList.get(6).equals("0") && numberList.get(4).equals("0")) {
                        if (numberList.get(2).equals("-")) {
                            numberList.set(2, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(0).equals("X") && numberList.get(6).equals("X") || numberList.get(4).equals("X") && numberList.get(5).equals("X")
                            || numberList.get(0).equals("0") && numberList.get(6).equals("0") || numberList.get(4).equals("0") && numberList.get(5).equals("0")) {
                        if (numberList.get(3).equals("-")) {
                            numberList.set(3, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(0).equals("X") && numberList.get(8).equals("X") || numberList.get(2).equals("X") && numberList.get(6).equals("X")
                            || numberList.get(1).equals("X") && numberList.get(7).equals("X") || numberList.get(3).equals("X") && numberList.get(5).equals("X")
                            || numberList.get(0).equals("0") && numberList.get(8).equals("0") || numberList.get(2).equals("0") && numberList.get(6).equals("0")
                            || numberList.get(1).equals("0") && numberList.get(7).equals("0") || numberList.get(3).equals("0") && numberList.get(5).equals("0")) {
                        if (numberList.get(4).equals("-")) {
                            numberList.set(4, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(3).equals("X") && numberList.get(4).equals("X") || numberList.get(2).equals("X") && numberList.get(8).equals("X")
                            || numberList.get(3).equals("0") && numberList.get(4).equals("0") || numberList.get(2).equals("0") && numberList.get(8).equals("0")) {
                        if (numberList.get(5).equals("-")) {
                            numberList.set(5, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(6).equals("X") && numberList.get(7).equals("X") || numberList.get(2).equals("X") && numberList.get(5).equals("X")
                            || numberList.get(0).equals("X") && numberList.get(4).equals("X") || numberList.get(6).equals("0") && numberList.get(7).equals("0")
                            || numberList.get(2).equals("0") && numberList.get(5).equals("0") || numberList.get(0).equals("0") && numberList.get(4).equals("0")) {
                        if (numberList.get(8).equals("-")) {
                            numberList.set(8, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(1).equals("X") && numberList.get(4).equals("X") || numberList.get(6).equals("X") && numberList.get(8).equals("X")
                            || numberList.get(1).equals("0") && numberList.get(4).equals("0") || numberList.get(6).equals("0") && numberList.get(8).equals("0")) {
                        if (numberList.get(7).equals("-")) {
                            numberList.set(7, "X");
                        } else {
                            fillUp();
                        }
                    } else if (numberList.get(0).equals("X") && numberList.get(3).equals("X") || numberList.get(2).equals("X") && numberList.get(4).equals("X")
                            || numberList.get(7).equals("X") && numberList.get(8).equals("X") || numberList.get(0).equals("0") && numberList.get(3).equals("0")
                            || numberList.get(2).equals("0") && numberList.get(4).equals("0") || numberList.get(7).equals("0") && numberList.get(8).equals("0")) {
                        if (numberList.get(6).equals("-")) {
                            numberList.set(6, "X");
                        } else {
                            fillUp();
                        }
                    } else {
                        int min = 0;
                        int max = 8;
                        int random = new Random().nextInt((max - min) + 1) + min;
                        for (int x = 0; x < numberList.size(); x++) {
                            if (numberList.get(random).equals("-")) {
                                numberList.set(random, "X");
                                break;
                            } else {
                                if (numberList.get(x).equals("-")) {
                                    numberList.set(x, "X");
                                    break;
                                }
                            }
                        }
                    } //////////////////////////////AI Finish
                    adapter.notifyDataSetChanged();
                }

                //playerInput 0 = human, playerInput X = AI
                playerInput("0");
                playerInput("X");

                if (!numberList.contains("-") && !isWin) {
                    resultScore.setText("DRAW!");
                    resetButton.setEnabled(true);

                } else {
                    isWin = false;
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < numberList.size(); i++) {
                    numberList.set(i, "-");
                }
                adapter.notifyDataSetChanged();
                gridView.setEnabled(true);
                resetButton.setEnabled(false);
                resultScore.setText("");
            }
        });
    }

    public void fillUp() {
        int x;
        for (x = 0; x < numberList.size(); x++) {
            if (numberList.get(x).equals("-")) {
                if (numberList.get(2).equals("0") && numberList.get(4).equals("0") && numberList.get(6).equals("0")) {
                } else if (numberList.get(6).equals("0") && numberList.get(4).equals("0") && numberList.get(8).equals("0")) {
                    if (numberList.get(x).equals("-")) numberList.set(x, "X");
                    break;
                } else if (numberList.get(0).equals("0") && numberList.get(1).equals("0") && numberList.get(2).equals("0")) {
                } else if (numberList.get(3).equals("0") && numberList.get(4).equals("0") && numberList.get(5).equals("0")) {
                } else if (numberList.get(6).equals("0") && numberList.get(7).equals("0") && numberList.get(8).equals("0")) {
                } else if (numberList.get(0).equals("0") && numberList.get(3).equals("0") && numberList.get(6).equals("0")) {
                } else if (numberList.get(1).equals("0") && numberList.get(4).equals("0") && numberList.get(7).equals("0")) {
                } else if (numberList.get(2).equals("0") && numberList.get(5).equals("0") && numberList.get(8).equals("0")) {
                } else if (numberList.get(0).equals("X") && numberList.get(4).equals("X") && numberList.get(8).equals("-")) {
                    numberList.set(8, "X");
                    break;
                } else if (numberList.get(2).equals("0") && numberList.get(8).equals("0") && numberList.get(5).equals("-")) {
                    numberList.set(5, "X");
                    break;
                } else if (numberList.get(4).equals("X") && numberList.get(5).equals("X") && numberList.get(3).equals("-")) {
                    numberList.set(3, "X");
                    break;
                } else if (numberList.get(1).equals("0") && numberList.get(6).equals("0") && numberList.get(8).equals("0")) {
                    if (numberList.get(7).equals("-")) {
                        numberList.set(7, "X");
                        break;
                    } else {
                        for (x = 0; x < numberList.size(); x++) {
                            if (numberList.get(x).equals("-")) {
                                numberList.set(x, "X");
                                break;
                            }
                        }
                    }
                    break;
                } else {
                    numberList.set(x, "X");
                    break;
                }
            }
        }
    }

    public void playerInput(String inputValue) {
        if (numberList.get(0).equals(inputValue) && numberList.get(1).equals(inputValue) && numberList.get(2).equals(inputValue)
                || numberList.get(3).equals(inputValue) && numberList.get(4).equals(inputValue) && numberList.get(5).equals(inputValue)
                || numberList.get(6).equals(inputValue) && numberList.get(7).equals(inputValue) && numberList.get(8).equals(inputValue)
                || numberList.get(0).equals(inputValue) && numberList.get(3).equals(inputValue) && numberList.get(6).equals(inputValue)
                || numberList.get(1).equals(inputValue) && numberList.get(4).equals(inputValue) && numberList.get(7).equals(inputValue)
                || numberList.get(2).equals(inputValue) && numberList.get(5).equals(inputValue) && numberList.get(8).equals(inputValue)
                || numberList.get(0).equals(inputValue) && numberList.get(4).equals(inputValue) && numberList.get(8).equals(inputValue)
                || numberList.get(2).equals(inputValue) && numberList.get(4).equals(inputValue) && numberList.get(6).equals(inputValue)) {

            if (inputValue.equals("0")) {
                playerOneGui();
                isWin = true;
            }
            if (inputValue.equals("X") && !isWin) {
                playerTwoGui();
                isWin = true;
            }
        }
    }

    public void playerOneGui() {
        resultScore.setText("Human Wins");
        gridView.setEnabled(false);
        resetButton.setEnabled(true);
        player0Result.setText(String.valueOf(playerOneResult + 1));
        playerOneResult++;
    }

    public void playerTwoGui() {
        resultScore.setText("Machine Wins");
        gridView.setEnabled(false);
        resetButton.setEnabled(true);
        player1Result.setText(String.valueOf(playerTwoResult + 1));
        playerTwoResult++;
    }
}