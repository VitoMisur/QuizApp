package com.example.android.dotaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    RadioButton abyssalBladeRB;
    RadioButton solarCrestRB;
    RadioButton axe;
    RadioButton sven;
    RadioButton purificationRB;
    RadioButton divineRapier;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    CheckBox exorcismCB;
    CheckBox liquid_fireCB;
    CheckBox dualBreathCB;
    CheckBox cryptSwarmCB;
    CheckBox battery_assaultCB;
    CheckBox lighting_boltCB;
    CheckBox reversePolarityCB;
    CheckBox dismemberCB;
    CheckBox dark_pactCB;
    CheckBox fortuneEndCB;
    CheckBox demonicPurgeCB;
    CheckBox kraken_shellCB;
    CheckBox magneticFieldCB;
    CheckBox acidSprayCB;
    CheckBox blurCB;
    CheckBox tetherCB;
    ImageView magneticField;
    ImageView acidSpray;
    ImageView blur;
    ImageView tether;
    ImageView darkPact;
    ImageView fortuneEnd;
    ImageView demonicPurge;
    ImageView krakenShell;
    ImageView reversePolarity;
    ImageView dismember;
    ImageView batteryAssault;
    ImageView lightningBolt;
    ImageView exorcism;
    ImageView dualBreath;
    ImageView liquidFire;
    ImageView cryptSwarm;
    ImageView laser;
    ImageView glyphIW;
    EditText juggquiz;
    EditText damageType;
    EditText abilityName;
    EditText nameEditText;
    TextView result;
    // defined variables
    int score = 0;
    int wrongS = 0;
    String results;
    String name;
    boolean on1 = false;
    boolean on2 = false;
    boolean on3 = false;
    boolean on4 = false;
    boolean on5 = false;
    boolean on6 = false;
    // anti crash magic
    boolean anti_crash = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        magneticField = findViewById(R.id.magnetic_field_icon);
        acidSpray = findViewById(R.id.acid_spray_icon);
        blur = findViewById(R.id.blur_icon);
        tether = findViewById(R.id.tether_icon);
        darkPact = findViewById(R.id.dark_pact_icon);
        fortuneEnd = findViewById(R.id.fortune_end_icon);
        demonicPurge = findViewById(R.id.demonic_purge_icon);
        krakenShell = findViewById(R.id.kraken_shell_icon);
        reversePolarity = findViewById(R.id.reverse_polarity_icon);
        dismember = findViewById(R.id.dismember_icon);
        batteryAssault = findViewById(R.id.battery_assault_icon);
        lightningBolt = findViewById(R.id.lightning_bolt_icon);
        exorcism = findViewById(R.id.exorcism_icon);
        dualBreath = findViewById(R.id.dual_breath_icon);
        liquidFire = findViewById(R.id.liquid_fire_icon);
        cryptSwarm = findViewById(R.id.crypt_swarm_icon);
        laser = findViewById(R.id.laser_icon);
        glyphIW = findViewById(R.id.glyph_icon);
        nameEditText = findViewById(R.id.name);

    }
    // method that runs after u click on submit button
    public void submitResult(View view) {
        // get name output from EditText
        name = nameEditText.getEditableText().toString();
        // just magic
        anti_crash=false;

        //checking every answer 1 by 1
        // and changing the score/wrong variables

        firstQuestion();

        secondQuestion();

        thirdQuestion();

        fourthQuestion();

        fifthQuestion();

        sixthQuestion();

        seventhQuestion();

        eighthQuestion();

        ninthQuestion();

        tenthQuestion();

        eleventhQuestion();

        // setting the result with the name from EditText field
        setResults(name);
        // reset the results after we output the score
        resultReset();
    }
    public void setResults(String nameJD)
    {
        // if name is missing set the name as J.Doe (unknown)
        if(nameJD.equals(""))
        {
         nameJD = "J.Doe";
        }
        // creating output result string using all collected data
        results = getString(R.string.editName,nameJD);
        results += "\n" + getString(R.string.score) + " " + score + getString(R.string.maxScore);
        results += "\n" + getString(R.string.wrong) + " " + wrongS;
        Toast.makeText(this, results, Toast.LENGTH_SHORT).show();
        // find & put string to the result TextView
        result = findViewById(R.id.result);
        result.setText(results);
    }
    public void firstQuestion() {
        // getting the input from checkboxes
        abyssalBladeRB = findViewById(R.id.abyssal_blade);
        boolean abyssal_blade_bool = abyssalBladeRB.isChecked();
        solarCrestRB = findViewById(R.id.solar_crest);
        boolean solar_crest_bool = solarCrestRB.isChecked();
        radioGroup1 = findViewById(R.id.radioGroupOne);
        // checking for the answers
        // and change the score
        if (abyssal_blade_bool || solar_crest_bool) {
            wrongS += 1;
        } else if (radioGroup1.getCheckedRadioButtonId() == -1) {
            wrongS += 1;
        } else {
            score += 1;
        }
    }

    public void secondQuestion() {
        acidSprayCB = findViewById(R.id.acid_spray);
        boolean acidSprayCB_bool = acidSprayCB.isChecked();
        tetherCB = findViewById(R.id.tether);
        boolean tetherCB_bool = tetherCB.isChecked();
        magneticFieldCB = findViewById(R.id.magnetic_field);
        boolean magnetic_fieldCB = magneticFieldCB.isChecked();
        blurCB = findViewById(R.id.blur);
        boolean blur_CB = blurCB.isChecked();
        if ((magnetic_fieldCB && blur_CB) && (!acidSprayCB_bool && !tetherCB_bool))
        {
            score += 2;
        } else if(magnetic_fieldCB && blur_CB && acidSprayCB_bool && tetherCB_bool)
        {
            score +=0;
            wrongS +=1;
        }
        else if((magnetic_fieldCB || blur_CB) && acidSprayCB_bool && tetherCB_bool)
        {
            score +=0;
            wrongS+=1;
        }
        else if (magnetic_fieldCB || blur_CB)  {
            score += 1;
        }
        else {
            wrongS += 1;
        }
    }

    public void thirdQuestion() {
        sven = findViewById(R.id.kunkka_sven);
        boolean sven_bool = sven.isChecked();
        axe = findViewById(R.id.kunkka_axe);
        boolean axe_bool = sven.isChecked();
        radioGroup2 = findViewById(R.id.radioGroupTwo);
        if (axe_bool || sven_bool) {
            wrongS += 1;
        } else if (radioGroup2.getCheckedRadioButtonId() == -1) {
            wrongS += 1;
        } else {
            score += 1;
        }
    }

    public void fourthQuestion() {
        fortuneEndCB = findViewById(R.id.fortune_end);
        boolean fortuneEndCB_bool = fortuneEndCB.isChecked();
        demonicPurgeCB = findViewById(R.id.demonic_purge);
        boolean demonicPurgeCB_bool = demonicPurgeCB.isChecked();
        dark_pactCB = findViewById(R.id.dark_pact);
        boolean darkPact = dark_pactCB.isChecked();
        kraken_shellCB = findViewById(R.id.kraken_shell);
        boolean krakenShell = kraken_shellCB.isChecked();
        if ((darkPact && krakenShell) && (!fortuneEndCB_bool && !demonicPurgeCB_bool))
        {
            score += 2;
        } else if(darkPact && krakenShell && fortuneEndCB_bool && demonicPurgeCB_bool)
        {
            score +=0;
            wrongS +=1;
        }
        else if((darkPact || krakenShell) && fortuneEndCB_bool && demonicPurgeCB_bool)
        {
            score +=0;
            wrongS+=1;
        }
        else if (darkPact || krakenShell)  {
            score += 1;
        }
        else {
            wrongS += 1;
        }
    }

    public void fifthQuestion() {
        // getting text input
        juggquiz = findViewById(R.id.jugg_name);
        String jugg = juggquiz.getEditableText().toString();
        // compare the inputs to the right answer
        if (jugg.equals("Юрнеро") || jugg.equals("Джаггернаут") || jugg.equals("Juggernaut") || jugg.equals("Yurnero") || jugg.equals("yurnero") || jugg.equals("juggernaut")) {
            score += 2;
        } else {
            wrongS += 1;
        }
    }

    public void sixthQuestion() {
        purificationRB = findViewById(R.id.purification);
        boolean purification_bool = purificationRB.isChecked();
        radioGroup3 = findViewById(R.id.radioGroupThree);
        if (purification_bool) {
            score += 2;
        }
        // getting the user input from the radio group by id
        else if ((radioGroup3.getCheckedRadioButtonId() == -1)) {
            wrongS += 1;
        } else {
            wrongS += 1;
        }
    }

    public void seventhQuestion() {
        reversePolarityCB = findViewById(R.id.reverse_polarity);
        boolean reversePolarityCB_bool = reversePolarityCB.isChecked();
        dismemberCB = findViewById(R.id.dismember);
        boolean dismemberCB_bool = dismemberCB.isChecked();
        battery_assaultCB = findViewById(R.id.battery_assault);
        boolean battery_assaultCB_bool = battery_assaultCB.isChecked();
        lighting_boltCB = findViewById(R.id.lightning_bolt);
        boolean lighting_boltCB_bool = lighting_boltCB.isChecked();
        if ((battery_assaultCB_bool && lighting_boltCB_bool) && (!dismemberCB_bool && !reversePolarityCB_bool))
        {
            score += 2;
        } else if(battery_assaultCB_bool && lighting_boltCB_bool && dismemberCB_bool && reversePolarityCB_bool)
        {
            score +=0;
            wrongS +=1;
        }
        else if((battery_assaultCB_bool || lighting_boltCB_bool) && dismemberCB_bool && reversePolarityCB_bool)
        {
            score +=0;
            wrongS+=1;
        }
        else if (battery_assaultCB_bool || lighting_boltCB_bool)  {
            score += 1;
        }
        else {
            wrongS += 1;
        }
    }

    public void eighthQuestion() {
        damageType = findViewById(R.id.pure_damage);
        String dmg = damageType.getEditableText().toString();
        if (dmg.equals("Pure") || dmg.equals("Чистый") || dmg.equals("чистый") || dmg.equals("pure")) {
            score += 2;
        } else {
            wrongS += 1;
        }
    }

    public void ninthQuestion() {
        abilityName = findViewById(R.id.glyph);
        String ability = abilityName.getEditableText().toString();
        if (ability.equals("Glyph of Fortification") || ability.equals("glyph of fortification") || ability.equals("glyph") || ability.equals("Glyph") || ability.equals("Глиф") || ability.equals("глиф")) {
            score += 2;
        } else {
            wrongS += 1;
        }
    }

    public void tenthQuestion() {
        divineRapier = findViewById(R.id.divine_rapier);
        boolean divine_rapier_bool = divineRapier.isChecked();
        radioGroup4 = findViewById(R.id.radioGroupFour);
        if (divine_rapier_bool) {
            score += 2;
        } else if ((radioGroup4.getCheckedRadioButtonId() == -1)) {
            wrongS += 1;
        } else {
            wrongS += 1;
        }
    }

    public void eleventhQuestion() {
        cryptSwarmCB = findViewById(R.id.crypt_swarm);
        boolean cryptSwarm_bool = cryptSwarmCB.isChecked();
        dualBreathCB = findViewById(R.id.dual_breath);
        boolean dualBreath_bool = dualBreathCB.isChecked();
        exorcismCB = findViewById(R.id.exorcism);
        boolean exorcism_bool = exorcismCB.isChecked();
        liquid_fireCB = findViewById(R.id.liquid_fire);
        boolean liquid_fire_bool = liquid_fireCB.isChecked();
        if ((exorcism_bool && liquid_fire_bool) && (!cryptSwarm_bool && !dualBreath_bool))
        {
            score += 2;
        } else if(exorcism_bool && liquid_fire_bool && cryptSwarm_bool && dualBreath_bool)
        {
            score +=0;
            wrongS +=1;
        }
            else if((exorcism_bool || liquid_fire_bool) && cryptSwarm_bool && dualBreath_bool)
            {
             score +=0;
             wrongS+=1;
            }
        else if (exorcism_bool || liquid_fire_bool)  {
            score += 1;
        }
        else {
            wrongS += 1;
        }
    }

    // logic for the 1rst question hint button
    public void visible_hint_one() {
        //if button is clicked and hints are visible = hide the hints on second click
        if (on1) {
            magneticField.setVisibility(View.INVISIBLE);
            acidSpray.setVisibility(View.INVISIBLE);
            blur.setVisibility(View.INVISIBLE);
            tether.setVisibility(View.INVISIBLE);
            on1 = false;
            // if button wasnt clicked before , make hints visible
        } else {
            magneticField.setVisibility(View.VISIBLE);
            acidSpray.setVisibility(View.VISIBLE);
            blur.setVisibility(View.VISIBLE);
            tether.setVisibility(View.VISIBLE);
            on1 = true;
        }
    }

    public void visible_hint_two() {
        if (on2) {
            darkPact.setVisibility(View.INVISIBLE);
            fortuneEnd.setVisibility(View.INVISIBLE);
            demonicPurge.setVisibility(View.INVISIBLE);
            krakenShell.setVisibility(View.INVISIBLE);
            on2 = false;
        } else {
            darkPact.setVisibility(View.VISIBLE);
            fortuneEnd.setVisibility(View.VISIBLE);
            demonicPurge.setVisibility(View.VISIBLE);
            krakenShell.setVisibility(View.VISIBLE);
            on2 = true;
        }
    }

    public void visible_hint_three() {
        if (on3) {
            reversePolarity.setVisibility(View.INVISIBLE);
            dismember.setVisibility(View.INVISIBLE);
            batteryAssault.setVisibility(View.INVISIBLE);
            lightningBolt.setVisibility(View.INVISIBLE);
            on3 = false;
        } else {
            reversePolarity.setVisibility(View.VISIBLE);
            dismember.setVisibility(View.VISIBLE);
            batteryAssault.setVisibility(View.VISIBLE);
            lightningBolt.setVisibility(View.VISIBLE);
            on3 = true;
        }
    }

    public void visible_hint_four() {
        if (on4) {
            laser.setVisibility(View.GONE);
            on4 = false;
        } else {
            laser.setVisibility(View.VISIBLE);
            on4 = true;
        }
    }

    public void visible_hint_five() {
        if (on5) {
            glyphIW.setVisibility(View.GONE);
            on5 = false;
        } else {
            glyphIW.setVisibility(View.VISIBLE);
            on5 = true;
        }
    }

    public void visible_hint_six() {
        if (on6) {
            exorcism.setVisibility(View.INVISIBLE);
            dualBreath.setVisibility(View.INVISIBLE);
            liquidFire.setVisibility(View.INVISIBLE);
            cryptSwarm.setVisibility(View.INVISIBLE);
            on6 = false;
        } else {
            exorcism.setVisibility(View.VISIBLE);
            dualBreath.setVisibility(View.VISIBLE);
            liquidFire.setVisibility(View.VISIBLE);
            cryptSwarm.setVisibility(View.VISIBLE);
            on6 = true;
        }
    }

    public void hintOne(View view) {
        visible_hint_one();
    }

    public void hintTwo(View view) {
        visible_hint_two();
    }

    public void hintThree(View view) {
        visible_hint_three();
    }

    public void hintFour(View view) {
        visible_hint_four();
    }

    public void hintFive(View view) {
        visible_hint_five();
    }

    public void hintSix(View view) {
        visible_hint_six();
    }

    // resetting the score results
    public void resultReset() {
        score = 0;
        wrongS = 0;
    }
    // clear all UI components to repeat the quiz
    public void clearALL()
    {
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();
        exorcismCB.setChecked(false);
        cryptSwarmCB.setChecked(false);
        dualBreathCB.setChecked(false);
        liquid_fireCB.setChecked(false);
        reversePolarityCB.setChecked(false);
        dismemberCB.setChecked(false);
        battery_assaultCB.setChecked(false);
        lighting_boltCB.setChecked(false);
        dark_pactCB.setChecked(false);
        fortuneEndCB.setChecked(false);
        demonicPurgeCB.setChecked(false);
        kraken_shellCB.setChecked(false);
        magneticFieldCB.setChecked(false);
        acidSprayCB.setChecked(false);
        blurCB.setChecked(false);
        tetherCB.setChecked(false);
        nameEditText.setText("");
        juggquiz.setText("");
        abilityName.setText("");
        damageType.setText("");
        result.setText("");
        setResults("J.Doe");
    }
    public void reset(View view) {
        // anti crash magic to prevent the crash cause of blank nameEditText
        if(anti_crash)
        {
            submitResult(findViewById(R.id.reset));
        }
        resultReset();
        clearALL();
        //checking all the hints and hide them if they are visible
        if (on1) {
            magneticField.setVisibility(View.INVISIBLE);
            acidSpray.setVisibility(View.INVISIBLE);
            blur.setVisibility(View.INVISIBLE);
            tether.setVisibility(View.INVISIBLE);
            on1 = false;
        }
        if (on2) {
            darkPact.setVisibility(View.INVISIBLE);
            fortuneEnd.setVisibility(View.INVISIBLE);
            demonicPurge.setVisibility(View.INVISIBLE);
            krakenShell.setVisibility(View.INVISIBLE);
            on2 = false;
        }
        if (on3) {
            reversePolarity.setVisibility(View.INVISIBLE);
            dismember.setVisibility(View.INVISIBLE);
            batteryAssault.setVisibility(View.INVISIBLE);
            lightningBolt.setVisibility(View.INVISIBLE);
            on3 = false;
        }
        if (on4) {
            laser.setVisibility(View.GONE);
            on4 = false;
        }
        if (on5) {
            glyphIW.setVisibility(View.GONE);
            on5 = false;
        }
    }
}