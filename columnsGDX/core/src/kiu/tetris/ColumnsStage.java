package kiu.tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import tetris.Controller;
import tetris.Graphics;
import tetris.Model;
import tetris.View;

public class ColumnsStage extends Stage implements Graphics {
	
	static Color[] COLORS = {
			Color.DARK_GRAY, Color.RED, Color.GREEN, 
			Color.BLUE, Color.CYAN, Color.YELLOW, 
			Color.MAGENTA, Color.MAROON,Color.WHITE};
	private ShapeRenderer shape;
	private View view;
	private Model model;
	private Controller controller;

	public ColumnsStage() {
		System.out.println("Initialization started");
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(true);
		setViewport(new ScreenViewport(camera));
		shape = new ShapeRenderer();
		Gdx.graphics.setWindowedMode(400, 700);
	}

	public void init() {
		model = new Model();
		view = new View(this);

		controller = new Controller(model,view);

//		model.addListener(controller);


		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
				controller.trySlideDown();
			}
		}, 1.0f, 1.0f);

		Gdx.input.setInputProcessor(this);

		addListener(new InputListener() {

			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				switch (keycode) {
				case Input.Keys.LEFT:
					controller.tryMoveLeft();
					break;
				case Input.Keys.RIGHT:
					controller.tryMoveRight();
					break;
				case Input.Keys.SPACE:
					controller.dropFigure();
					break;
				case Input.Keys.UP:
					controller.rotateUp();
					break;
				case Input.Keys.DOWN:
					controller.rotateDown();
					break;
				}
				return true;
			}

		});

	}




	@Override
	public void draw() {
		view.draw(model);
	}

	@Override
	public void drawBoxAt(int x, int y, int size, int colorIndex) {
		Camera camera = getViewport().getCamera();
		camera.update();

		shape.setProjectionMatrix(camera.combined);

		shape.begin(ShapeType.Filled);
		shape.setColor(COLORS[colorIndex]);
		shape.rect(x, y, size, size);
		shape.end();
	}



}
