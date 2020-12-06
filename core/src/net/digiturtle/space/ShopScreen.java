package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class ShopScreen extends Screen {

	private Ship ship;
	
	private Stage stage;
	private Label coins;
	private ShopItem[] shopItems;
	private ShopTab shopTab;
	
	public enum ShopTab {
		Thrusters,
		Shields,
		Phasers;
	}
	private class ShopItem {
		Image icon;
		Label title, cost;
		TextButton action;
	}
	
	public ShopScreen (Ship ship) {
		this.ship = ship;
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		stage = new Stage();
		
		shopItems = new ShopItem[3];
		for (int i = 0; i < 3; i++) {
			shopItems[i] = new ShopItem();
			shopItems[i].icon = new Image();
			shopItems[i].icon.setBounds(20, height - 320 - (i * 100), 80, 80);
			stage.addActor(shopItems[i].icon);
			shopItems[i].title = new Label("Item Name", Textures.SKIN);
			shopItems[i].title.setPosition(20 + 80 + 20, height - 280 - (i * 100));
			stage.addActor(shopItems[i].title);
			shopItems[i].cost = new Label("0 Coins", Textures.SKIN);
			shopItems[i].cost.setPosition(20 + 80 + 20, height - 320 - (i * 100));
			stage.addActor(shopItems[i].cost);
			shopItems[i].action = new TextButton("Buy", Textures.SKIN);
			shopItems[i].action.setBounds(width - 100 - 20, height - 300 - (i * 100), 100, 40);
			stage.addActor(shopItems[i].action);
			shopItems[i].action.addListener(new ClickListener() {
				public void clicked (InputEvent evt, float x, float y) {
					//TODO
				}
			});
		}
		
		TextButton back = new TextButton("Back", Textures.SKIN);
		back.setBounds(10, height - 10 - 50, width / 3, 50);
		back.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(MENU_SCREEN);
			}
		});
		stage.addActor(back);
		
		coins = new Label("0 Coins", Textures.SKIN);
		coins.setAlignment(Align.left);
		coins.setPosition(width / 3, height - 10 - 50 - 60 + 20);
		stage.addActor(coins);

		TextButton thrusters = new TextButton("Thrusters", Textures.SKIN);
		thrusters.setBounds(10, height - 10 - 50 - 60 - 50, width / 3 - 15, 50);
		thrusters.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				selectShopScreen(ShopTab.Thrusters);
			}
		});
		stage.addActor(thrusters);

		TextButton shields = new TextButton("Shields", Textures.SKIN);
		shields.setBounds(10 + width / 3 - 2, height - 10 - 50 - 60 - 50, width / 3 - 15, 50);
		shields.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				selectShopScreen(ShopTab.Shields);
			}
		});
		stage.addActor(shields);

		TextButton phasers = new TextButton("Phasers", Textures.SKIN);
		phasers.setBounds(10 + width / 3 + width / 3 - 5, height - 10 - 50 - 60 - 50, width / 3 - 15, 50);
		phasers.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				selectShopScreen(ShopTab.Phasers);
			}
		});
		stage.addActor(phasers);
		
		selectShopScreen(ShopTab.Thrusters);
	}
	
	private void selectShopScreen (ShopTab shopTab) {
		this.shopTab = shopTab;
		shopItems[0].icon.setDrawable(new TextureRegionDrawable(Textures.ICON_SET[0 + shopTab.ordinal()*3]));
		shopItems[1].icon.setDrawable(new TextureRegionDrawable(Textures.ICON_SET[1 + shopTab.ordinal()*3]));
		shopItems[2].icon.setDrawable(new TextureRegionDrawable(Textures.ICON_SET[2 + shopTab.ordinal()*3]));
		
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		coins.setText(ship.coins + " Coins");
	}
	
}
