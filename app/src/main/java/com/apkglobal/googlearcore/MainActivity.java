package com.apkglobal.googlearcore;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable
            bearRenderable, catRenderable, cowRenderable, dogRenderable, elephantRenderable, ferretRenderable, hippoRenderable, horseRenderable, koala_bearRenderable, lionRenderable, reindeerRenderable, wolverineRenderable;
    ImageView bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine;
    View arrayView[];
    ViewRenderable animal_name;
    int selected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);


        initializedView();

        setArrayView();

        setClickListener();

        setUpModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode, selected);

            }
        });

    }

    private void initializedView() {
        bear = findViewById(R.id.bear);
        cat = findViewById(R.id.cat);
        cow = findViewById(R.id.cow);
        dog = findViewById(R.id.dog);
        elephant = findViewById(R.id.elephant);
        ferret = findViewById(R.id.ferret);
        hippo = findViewById(R.id.hippo);
        horse = findViewById(R.id.horse);
        koala = findViewById(R.id.koala_bear);
        lion = findViewById(R.id.lion);
        reindeer = findViewById(R.id.reindeer);
        wolverine = findViewById(R.id.wolverine);
    }

    private void setUpModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build()
                .thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build()
                .thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load cat model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build()
                .thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load cow model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build()
                .thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load dog model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build()
                .thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to elephant bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build()
                .thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load ferret model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build()
                .thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load hippopotamus model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build()
                .thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load horse model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build()
                .thenAccept(renderable -> koala_bearRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load koala_bear model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build()
                .thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load lion model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build()
                .thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load reindeer model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build()
                .thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast.makeText(this, "Unable to load wolverine model", Toast.LENGTH_SHORT).show();
                            return null;
                        });


    }


    private void createModel(AnchorNode anchorNode, int selected) {

        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode,bear,"Bear");
        }
        if (selected == 2) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(catRenderable);
            bear.select();

            addName(anchorNode,bear,"Cat");
        }
        if (selected == 3) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.select();

            addName(anchorNode,bear,"Cow");
        }
        if (selected == 4) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(dogRenderable);
            bear.select();

            addName(anchorNode,bear,"Dog");
        }
        if (selected == 5) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(elephantRenderable);
            bear.select();

            addName(anchorNode,bear,"Elephant");
        }
        if (selected == 6) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(ferretRenderable);
            bear.select();

            addName(anchorNode,bear,"Ferret");
        }
        if (selected == 7) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hippoRenderable);
            bear.select();

            addName(anchorNode,bear,"Hippopotamus");
        }
        if (selected == 8) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(horseRenderable);
            bear.select();

            addName(anchorNode,bear,"Horse");
        }
        if (selected == 9) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(koala_bearRenderable);
            bear.select();

            addName(anchorNode,bear,"koala Bear");
        }
        if (selected == 10) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(lionRenderable);
            bear.select();

            addName(anchorNode,bear,"Lion");
        }
        if (selected == 11) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(reindeerRenderable);
            bear.select();

            addName(anchorNode,bear,"Reindeer");
        }
        if (selected == 12) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(wolverineRenderable);
            bear.select();

            addName(anchorNode,bear,"Wolverine");
        }
    }


    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        ViewRenderable.builder().setView(this,R.layout.name_animal)
                .build()
                .thenAccept(viewRendrable->{
                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRendrable);
                    nameView.select();

                    TextView textName= (TextView) viewRendrable.getView();
                    textName.setText(name);

                    textName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            anchorNode.setParent(null);
                        }
                    });
                });


    }


    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++) {
            arrayView[i].setOnClickListener(this);
        }
    }


    private void setArrayView() {
        arrayView = new View[]{bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine};
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.bear){
            selected=1;
            setBackground(v.getId());
        }else if(v.getId()==R.id.cat) {
            selected = 2;
            setBackground(v.getId());
        }else if(v.getId()==R.id.cow) {
            selected = 3;
            setBackground(v.getId());
        }else if(v.getId()==R.id.dog) {
            selected = 4;
            setBackground(v.getId());
        }else if(v.getId()==R.id.elephant) {
            selected = 5;
            setBackground(v.getId());
        }else if(v.getId()==R.id.ferret) {
            selected = 6;
            setBackground(v.getId());
        }else if(v.getId()==R.id.hippo) {
            selected = 7;
            setBackground(v.getId());
        }else if(v.getId()==R.id.horse) {
            selected = 8;
            setBackground(v.getId());
        }else if(v.getId()==R.id.koala_bear) {
            selected = 9;
            setBackground(v.getId());
        }else if(v.getId()==R.id.lion) {
            selected = 10;
            setBackground(v.getId());
        }else if(v.getId()==R.id.reindeer) {
            selected = 11;
            setBackground(v.getId());
        }else if(v.getId()==R.id.wolverine) {
            selected = 12;
            setBackground(v.getId());
        }
    }


    private void setBackground(int id) {
        for (int i=0;i<arrayView.length;i++){
            if(arrayView[i].getId()==id)
            {
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            }else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
