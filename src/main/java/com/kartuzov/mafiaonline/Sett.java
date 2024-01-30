package com.kartuzov.mafiaonline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.kartuzov.mafiaonline.WindowINRoomScreen.MatchMaking.TableInRoomScreen;
import java.util.Iterator;
import org.json.JSONException;

@SuppressWarnings("GDXJavaInvalidPropertyKey")
public class Sett implements Screen {
    public static boolean GolosProtiv;
    public static boolean Incognito;
    static TextureRegion PlusI;
    public static SocketHints hints;
    static TextureRegion textureBtnRoleInRoom;
    static boolean zagruzka_music;
    TextureRegion Back_setI;
    TextureRegion BezGalka;
    Texture FonI;
    TextureRegion Galka;
    TextureRegion GameCloseI;
    TextureRegion GameOpenI;
    TextureRegion GamePoluI;
    TextureRegion GoI;
    int KolRolei = 0;
    TextureRegion MinusI;
    Actor QbtnBessmert;
    Actor QbtnDon;
    Actor QbtnGameStyle;
    Actor QbtnGolosProtiv;
    Actor QbtnManiac;
    Actor QbtnMed;
    Actor QbtnPutana;
    Actor QbtnSherif;
    Button QbtnTwoface;
    Button QbtnVor;
    TextureRegion QuestI;
    float R;
    float Rc1;
    float Rc2;
    float Rc3;
    float Rc4;
    float Rc5;
    float Rc6;
    float Rc7;
    TextureRegion SetI;
    AssetManager assetManager;
    Actor btnBack;
    CheckBox btnBessmert;
    CheckBox btnDon;
    Actor btnGameStyle;
    Actor btnGo;
    Actor btnGolosProtiv;
    CheckBox btnManiac;
    CheckBox btnMed;
    Actor btnMinus;
    Actor btnMinusM;
    Actor btnPlus;
    Actor btnPlusM;
    CheckBox btnPutana;
    CheckBox btnSherif;
    CheckBox btnTwoface;
    CheckBox btnVor;
    OrthographicCamera camera;
    Table container;
    final Mafia game;
    public TextButton message;
    float numberCart;
    ScrollPane scroll;
    boolean setScreen;
    Skin skin;
    Table table;
    Viewport viewport;
    Image wait;
    AssetManager asManager;
    Texture creatorFon;

    public Sett(Mafia var1) {
        this.game = var1;

        asManager = new AssetManager();
        asManager.load("Setting.png", Texture.class);
        asManager.load("CloseGame.png", Texture.class);
        asManager.load("OpenGame.png", Texture.class);
        asManager.load("PolyCloseGame.png", Texture.class);
        asManager.load("CreatorFon.jpg", Texture.class);
        asManager.finishLoading();

        this.creatorFon = (asManager.get("CreatorFon.jpg", Texture.class));
        this.SetI = new TextureRegion(asManager.get("Setting.png", Texture.class));
        PlusI = Mafia.atlas.findRegion("plus");
        textureBtnRoleInRoom = Mafia.atlas.findRegion("btnRoleInRoom");
        this.MinusI = Mafia.atlas.findRegion("minus");
        this.BezGalka = Mafia.atlas.findRegion("BezGalki");
        this.Galka = Mafia.atlas.findRegion("Galka");
        this.QuestI = Mafia.atlas.findRegion("questI");
        this.GoI = Mafia.atlas.findRegion("Start");
        this.Back_setI = Mafia.atlas.findRegion("Backset");
        this.GameCloseI = new TextureRegion(asManager.get("CloseGame.png", Texture.class));
        this.GameOpenI = new TextureRegion(asManager.get("OpenGame.png", Texture.class));
        this.GamePoluI = new TextureRegion(asManager.get("PolyCloseGame.png", Texture.class));
        this.skin = this.game.game.skin;
        this.container = new Table();
        this.container.debug();
        this.container.setHeight(330.0F);
        this.container.setWidth(300.0F);
        this.container.setX(490.0F);
        this.container.setY(120.0F);
        this.table = new Table();
        this.scroll = new ScrollPane(this.table, this.game.game.skin);
        this.scroll.setFadeScrollBars(false);
        this.scroll.setVariableSizeKnobs(false);
        this.scroll.setScrollingDisabled(true, false);
        this.table.defaults().expand().space(4.0F).pad(5.0F);
        this.btnGo = new Actor();
        this.btnGo.setX(550.0F);
        this.btnGo.setY(55.0F);
        this.btnGo.setWidth(200.0F);
        this.btnGo.setHeight(60.0F);
        this.btnGo.addListener(new GoListner(this));
        this.btnGolosProtiv = new Actor();
        this.btnGolosProtiv.setX(280.0F);
        this.btnGolosProtiv.setY(75.0F);
        this.btnGolosProtiv.setWidth(50.0F);
        this.btnGolosProtiv.setHeight(40.0F);
        this.btnGolosProtiv.addListener(new GolosProtivListner(this));
        this.btnGameStyle = new Actor();
        this.btnGameStyle.setX(240.0F);
        this.btnGameStyle.setY(147.0F);
        this.btnGameStyle.setWidth(120.0F);
        this.btnGameStyle.setHeight(50.0F);
        this.btnGameStyle.addListener(new GameStyleListner(this));
        this.btnPlus = new Actor();
        this.btnPlus.setX(210.0F);
        this.btnPlus.setY(345.0F);
        this.btnPlus.setWidth(50.0F);
        this.btnPlus.setHeight(40.0F);
        this.btnPlus.addListener(new PlusListner(this));
        this.btnMinus = new Actor();
        this.btnMinus.setX(90.0F);
        this.btnMinus.setY(345.0F);
        this.btnMinus.setWidth(50.0F);
        this.btnMinus.setHeight(40.0F);
        this.btnMinus.addListener(new MinusListner(this));
        this.btnPlusM = new Actor();
        this.btnPlusM.setX(210.0F);
        this.btnPlusM.setY(223.0F);
        this.btnPlusM.setWidth(50.0F);
        this.btnPlusM.setHeight(40.0F);
        this.btnPlusM.addListener(new PlusMListner(this));
        this.btnMinusM = new Actor();
        this.btnMinusM.setX(90.0F);
        this.btnMinusM.setY(223.0F);
        this.btnMinusM.setWidth(50.0F);
        this.btnMinusM.setHeight(40.0F);
        this.btnMinusM.addListener(new MinusMListner(this));
        this.btnMed = new CheckBox("", this.skin, "sett");
        this.btnMed.setOrigin(16);
        this.btnMed.setWidth(70.0F);
        this.btnMed.setHeight(50.0F);
        this.btnMed.addListener(new MedListner(this));
        this.btnSherif = new CheckBox("", this.skin, "sett");
        this.btnSherif.setOrigin(8);
        this.btnSherif.setWidth(50.0F);
        this.btnSherif.setHeight(40.0F);
        this.btnSherif.addListener(new SherifListner(this));
        this.btnManiac = new CheckBox("", this.skin, "sett");
        this.btnManiac.setWidth(50.0F);
        this.btnManiac.setHeight(40.0F);
        this.btnManiac.addListener(new ManiacListner(this));
        this.btnDon = new CheckBox("", this.skin, "sett");
        this.btnDon.setWidth(50.0F);
        this.btnDon.setHeight(40.0F);
        this.btnDon.addListener(new DonListn(this));
        this.btnPutana = new CheckBox("", this.skin, "sett");
        this.btnPutana.setWidth(50.0F);
        this.btnPutana.setHeight(40.0F);
        this.btnPutana.addListener(new PutanaListn(this));
        this.btnBessmert = new CheckBox("", this.skin, "sett");
        this.btnBessmert.setWidth(50.0F);
        this.btnBessmert.setHeight(40.0F);
        this.btnBessmert.addListener(new BessmertListn(this));
        this.btnTwoface = new CheckBox("", this.skin, "sett");
        this.btnTwoface.setWidth(50.0F);
        this.btnTwoface.setHeight(40.0F);
        this.btnTwoface.addListener(new TwofaceListn(this));
        this.btnVor = new CheckBox("", this.skin, "sett");
        this.btnVor.setWidth(50.0F);
        this.btnVor.setHeight(40.0F);
        this.btnVor.addListener(new VorListn(this));
        this.QbtnMed = new Button(this.skin);
        this.QbtnMed.setWidth(90.0F);
        this.QbtnMed.setHeight(40.0F);
        this.QbtnMed.addListener(new QMedListner(this));
        this.QbtnSherif = new Button(this.skin);
        this.QbtnSherif.setWidth(90.0F);
        this.QbtnSherif.setHeight(40.0F);
        this.QbtnSherif.addListener(new QSherifListner(this));
        this.QbtnManiac = new Button(this.skin);
        this.QbtnManiac.setWidth(90.0F);
        this.QbtnManiac.setHeight(40.0F);
        this.QbtnManiac.addListener(new QManiacListner(this));
        this.QbtnDon = new Button(this.skin);
        this.QbtnDon.setWidth(90.0F);
        this.QbtnDon.setHeight(40.0F);
        this.QbtnDon.addListener(new QDonListn(this));
        this.QbtnPutana = new Button(this.skin);
        this.QbtnPutana.setWidth(90.0F);
        this.QbtnPutana.setHeight(40.0F);
        this.QbtnPutana.addListener(new QPutanaListn(this));
        this.QbtnBessmert = new Button(this.skin);
        this.QbtnBessmert.setWidth(90.0F);
        this.QbtnBessmert.setHeight(40.0F);
        this.QbtnBessmert.addListener(new QBessmertListn(this));
        this.QbtnTwoface = new Button(this.skin);
        this.QbtnTwoface.addListener(new QTwofaceListn(this));
        this.QbtnVor = new Button(this.skin);
        this.QbtnVor.addListener(new QVorListn(this));
        var1 = this.game;
        Label var9 = new Label(Mafia.local.get("doc"), this.skin);
        var9.setFontScale(0.82F);
        Mafia var2 = this.game;
        Label var10 = new Label(Mafia.local.get("sherif"), this.skin);
        var10.setFontScale(0.82F);
        Mafia var3 = this.game;
        Label var11 = new Label(Mafia.local.get("maniac"), this.skin);
        var11.setFontScale(0.82F);
        Mafia var4 = this.game;
        Label var12 = new Label(Mafia.local.get("don"), this.skin);
        var12.setFontScale(0.82F);
        Mafia var5 = this.game;
        Label var13 = new Label(Mafia.local.get("putana"), this.skin);
        var13.setFontScale(0.82F);
        Mafia var6 = this.game;
        Label var14 = new Label(Mafia.local.get("bessmert"), this.skin);
        var14.setFontScale(0.75F);
        Mafia var7 = this.game;
        Label var15 = new Label(Mafia.local.get("twoface"), this.skin);
        var15.setFontScale(0.82F);
        Mafia var8 = this.game;
        Label var16 = new Label(Mafia.local.get("vor"), this.skin);
        var16.setFontScale(0.82F);
        this.table.add(this.QbtnMed).right().width(40.0F).height(40.0F);
        this.table.add(var9).left();
        this.table.add(this.btnMed).left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnSherif).right().width(40.0F).height(40.0F);
        this.table.add(var10).left();
        this.table.add(this.btnSherif).left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnManiac).right().width(40.0F).height(40.0F);
        this.table.add(var11).left();
        this.table.add(this.btnManiac).left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnDon).right().width(40.0F).height(40.0F);
        this.table.add(var12).left();
        this.table.add(this.btnDon).expand().left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnPutana).right().width(40.0F).height(40.0F);
        this.table.add(var13).left();
        this.table.add(this.btnPutana).expand().left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnBessmert).right().width(40.0F).height(40.0F);
        this.table.add(var14).left();
        this.table.add(this.btnBessmert).expand().left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnTwoface).right().width(40.0F).height(40.0F);
        this.table.add(var15).left();
        this.table.add(this.btnTwoface).expand().left().width(50.0F).height(40.0F);
        this.table.row();
        this.table.add(this.QbtnVor).right().width(40.0F).height(40.0F);
        this.table.add(var16).left();
        this.table.add(this.btnVor).expand().left().width(50.0F).height(40.0F);
        this.container.add(this.scroll).width(300.0F).padTop(18.0F).padBottom(14.0F);
        this.QbtnGolosProtiv = new Actor();
        this.QbtnGolosProtiv.setX(15.0F);
        this.QbtnGolosProtiv.setY(78.0F);
        this.QbtnGolosProtiv.setWidth(90.0F);
        this.QbtnGolosProtiv.setHeight(40.0F);
        this.QbtnGolosProtiv.addListener(new QGolosProtivListn(this));
        this.QbtnGameStyle = new Actor();
        this.QbtnGameStyle.setX(15.0F);
        this.QbtnGameStyle.setY(157.0F);
        this.QbtnGameStyle.setWidth(90.0F);
        this.QbtnGameStyle.setHeight(40.0F);
        this.QbtnGameStyle.addListener(new QGameStyleListn(this));
        this.btnBack = new Actor();
        this.btnBack.setX(0.0F);
        this.btnBack.setY(430.0F);
        this.btnBack.setWidth(100.0F);
        this.btnBack.setHeight(50.0F);
        this.btnBack.addListener(new Back_toStart_Listner(this));
        this.message = new TextButton("", this.game.game.skin, "message");
        this.message.setWidth(460.0F);
        this.message.setHeight(115.0F);
        this.message.setX(170.0F);
        this.message.setY(-140.0F);
    }

    public void ErrorMes(int var1) {
        this.btnGo.setTouchable(Touchable.enabled);
        this.wait.removeAction((Action)this.wait.getActions().get(0));
        this.wait.setDrawable((Drawable)null);
        this.message.getLabel().setWrap(true);
        this.message.setWidth(460.0F);
        this.message.setHeight(115.0F);
        this.message.setX(170.0F);
        this.message.setY(-140.0F);
        if (var1 == 1) {
            this.message.setText("Взламывать игры ХОРОШО!!!");
        } else {
            TextButton var2 = this.message;
            Mafia var3 = this.game;
            var2.setText(Mafia.local.get("host_name_not_uniq"));
        }

        this.message.addAction(Actions.sequence(Actions.moveTo(this.message.getX(), this.message.getY() + this.message.getHeight(), 0.7F), Actions.delay(3.0F), Actions.moveTo(this.message.getX(), this.message.getY() - this.message.getHeight(), 2.0F)));
    }

    public boolean balance(int var1) {
        switch (var1) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                return false;
        }
    }

    public void dispose() {
    }

    public void hide() {
    }

    public void loadmusic() {
        if (MyGame.MusicNight1 == null) {
            MyGame.MusicNight1 = Gdx.audio.newMusic(Gdx.files.internal("Night1.mp3"));
            MyGame.MusicNight2 = Gdx.audio.newMusic(Gdx.files.internal("Night3.mp3"));
            if (Setting.ninga && MyGame.MusicNight3 == null) {
                MyGame.MusicNight3 = Gdx.audio.newMusic(Gdx.files.internal("VampNight.mp3"));
            }

            MyGame.Golosovanie1 = Gdx.audio.newMusic(Gdx.files.internal("Golosovanie1.mp3"));
            MyGame.Golosovanie2 = Gdx.audio.newMusic(Gdx.files.internal("Golosovanie2.mp3"));
            MyGame.MusicNight.add(MyGame.MusicNight1);
            MyGame.MusicNight.add(MyGame.MusicNight2);
            if (Setting.ninga) {
                MyGame.MusicNight.add(MyGame.MusicNight3);
            }

            MyGame.MusicGolosovanie.add(MyGame.Golosovanie1);
            MyGame.MusicGolosovanie.add(MyGame.Golosovanie2);
            PauseGame.AllMusic.add(MyGame.MusicNight1);
            PauseGame.AllMusic.add(MyGame.MusicNight2);
            PauseGame.AllMusic.add(MyGame.MusicNight3);
            PauseGame.AllMusic.add(MyGame.Golosovanie1);
            PauseGame.AllMusic.add(MyGame.Golosovanie2);
            MyGame.GorodZasipaet = Gdx.audio.newMusic(Gdx.files.internal("gorodZasipaet2.mp3"));
            MyGame.AwaykMafia = Gdx.audio.newMusic(Gdx.files.internal("AwaykMafia2.mp3"));
            MyGame.AwaykGorod = Gdx.audio.newMusic(Gdx.files.internal("AwaykGOROD2.mp3"));
            MenuCart.MafiaSleep = Gdx.audio.newMusic(Gdx.files.internal("MafiSleep2.mp3"));
            MenuCart.ManiacAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykManiac2.mp3"));
            MenuCart.ManiacKill = Gdx.audio.newMusic(Gdx.files.internal("ManiakKill2.mp3"));
            MenuCart.ManiacSleep = Gdx.audio.newMusic(Gdx.files.internal("ManiacSleep2.mp3"));
            MenuCart.DoctorAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykDoctor2.mp3"));
            MenuCart.DoctorHeal = Gdx.audio.newMusic(Gdx.files.internal("DoctorHeal2.mp3"));
            MenuCart.DoctorSleep = Gdx.audio.newMusic(Gdx.files.internal("DoctorSleep2.mp3"));
            MenuCart.TwofaceAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykTwoface.mp3"));
            MenuCart.TwofaceDo = Gdx.audio.newMusic(Gdx.files.internal("TwofaceDo.mp3"));
            MenuCart.TwofaceSleep = Gdx.audio.newMusic(Gdx.files.internal("TwofaceSleep.mp3"));
            MenuCart.VampAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykVamp.mp3"));
            MenuCart.VampBite = Gdx.audio.newMusic(Gdx.files.internal("Vamp_bite_new.mp3"));
            MenuCart.VampSleep = Gdx.audio.newMusic(Gdx.files.internal("Vamp_Sleep_new.mp3"));
            MenuCart.NingaAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykNinga.mp3"));
            MenuCart.NingaAct = Gdx.audio.newMusic(Gdx.files.internal("NingaAct.mp3"));
            MenuCart.NingaSleep = Gdx.audio.newMusic(Gdx.files.internal("NingaSleep.mp3"));
            MenuCart.VorAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykVor.mp3"));
            MenuCart.VorSleep = Gdx.audio.newMusic(Gdx.files.internal("SleepVor.mp3"));
            MenuCart.SherifAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykSherif2.mp3"));
            MenuCart.SherifCheck = Gdx.audio.newMusic(Gdx.files.internal("SherifCheck2.mp3"));
            MenuCart.SherifSleep = Gdx.audio.newMusic(Gdx.files.internal("SherifSleep2.mp3"));
            MenuCart.DonAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykDon2.mp3"));
            MenuCart.DonCheck = Gdx.audio.newMusic(Gdx.files.internal("DonSheck2.mp3"));
            MenuCart.DonSleep = Gdx.audio.newMusic(Gdx.files.internal("DonSleep2.mp3"));
            MenuCart.PutanaAwayk = Gdx.audio.newMusic(Gdx.files.internal("AwaykPutana2.mp3"));
            MenuCart.PutanaSEX = Gdx.audio.newMusic(Gdx.files.internal("PutanaSEX2.mp3"));
            MenuCart.PutanaSleep = Gdx.audio.newMusic(Gdx.files.internal("PutanaSleep2.mp3"));
            PauseGame.AllMusic.add(MyGame.GorodZasipaet);
            PauseGame.AllMusic.add(MyGame.AwaykMafia);
            PauseGame.AllMusic.add(MyGame.AwaykGorod);
            PauseGame.AllMusic.add(MenuCart.MafiaSleep);
            PauseGame.AllMusic.add(MenuCart.ManiacAwayk);
            PauseGame.AllMusic.add(MenuCart.ManiacKill);
            PauseGame.AllMusic.add(MenuCart.ManiacSleep);
            PauseGame.AllMusic.add(MenuCart.SherifAwayk);
            PauseGame.AllMusic.add(MenuCart.SherifCheck);
            PauseGame.AllMusic.add(MenuCart.SherifSleep);
            PauseGame.AllMusic.add(MenuCart.DonAwayk);
            PauseGame.AllMusic.add(MenuCart.DonCheck);
            PauseGame.AllMusic.add(MenuCart.DonSleep);
            PauseGame.AllMusic.add(MenuCart.DoctorAwayk);
            PauseGame.AllMusic.add(MenuCart.DoctorHeal);
            PauseGame.AllMusic.add(MenuCart.DoctorSleep);
            PauseGame.AllMusic.add(MenuCart.PutanaAwayk);
            PauseGame.AllMusic.add(MenuCart.PutanaSEX);
            PauseGame.AllMusic.add(MenuCart.PutanaSleep);
            this.game.cart.nightAction.setMusic();
        }

    }

    public void pause() {
    }

    public void render(float var1) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(this.creatorFon, 0, 0, creatorFon.getWidth(), creatorFon.getHeight());
        this.game.batch.draw(this.SetI, 280.0F, 425.0F, 300.0F, 70.0F);
        this.game.batch.draw(this.GoI, this.btnGo.getX(), this.btnGo.getY(), this.btnGo.getWidth(), this.btnGo.getHeight());
        BitmapFont var2 = this.game.fontGame;
        SpriteBatch var3 = this.game.batch;
        Mafia var4 = this.game;
        var2.draw(var3, Mafia.local.get("count_of_players"), 30.0F, 422.0F);
        this.game.batch.draw(PlusI, this.btnPlus.getX(), this.btnPlus.getY(), this.btnPlus.getWidth(), this.btnPlus.getHeight());
        this.game.batch.draw(this.MinusI, this.btnMinus.getX(), this.btnMinus.getY(), this.btnMinus.getWidth(), this.btnMinus.getHeight());
        this.game.fontGame.draw(this.game.batch, Integer.toString(Setting.numberPlayer), 167.0F, 376.0F);
        BitmapFont var7 = this.game.fontGame;
        SpriteBatch var5 = this.game.batch;
        var4 = this.game;
        var7.draw(var5, Mafia.local.get("game_mode"), 60.0F, 187.0F);
        switch (Setting.game_style) {
            case 0:
                this.game.batch.draw(this.GameOpenI, this.btnGameStyle.getX(), this.btnGameStyle.getY(), this.btnGameStyle.getWidth(), this.btnGameStyle.getHeight());
                break;
            case 1:
                this.game.batch.draw(this.GamePoluI, this.btnGameStyle.getX(), this.btnGameStyle.getY(), this.btnGameStyle.getWidth(), this.btnGameStyle.getHeight());
                break;
            case 2:
                this.game.batch.draw(this.GameCloseI, this.btnGameStyle.getX(), this.btnGameStyle.getY(), this.btnGameStyle.getWidth(), this.btnGameStyle.getHeight());
        }

        var2 = this.game.fontGame;
        var3 = this.game.batch;
        var4 = this.game;
        var2.draw(var3, Mafia.local.get("incognito_mode"), 60.0F, 110.0F);
        if (!Incognito) {
            this.game.batch.draw(this.BezGalka, this.btnGolosProtiv.getX(), this.btnGolosProtiv.getY(), this.btnGolosProtiv.getWidth(), this.btnGolosProtiv.getHeight());
        } else {
            this.game.batch.draw(this.Galka, this.btnGolosProtiv.getX(), this.btnGolosProtiv.getY(), this.btnGolosProtiv.getWidth(), this.btnGolosProtiv.getHeight());
        }

        var7 = this.game.fontGame;
        SpriteBatch var9 = this.game.batch;
        Mafia var6 = this.game;
        var7.draw(var9, Mafia.local.get("count_of_mafia"), 30.0F, 302.0F);
        this.game.batch.draw(PlusI, this.btnPlusM.getX(), this.btnPlusM.getY(), this.btnPlusM.getWidth(), this.btnPlusM.getHeight());
        this.game.batch.draw(this.MinusI, this.btnMinusM.getX(), this.btnMinusM.getY(), this.btnMinusM.getWidth(), this.btnMinusM.getHeight());
        this.game.fontGame.draw(this.game.batch, Integer.toString(Setting.numberMafia), 170.0F, 252.0F);
        this.game.batch.draw(this.Back_setI, this.btnBack.getX(), this.btnBack.getY(), this.btnBack.getWidth(), this.btnBack.getHeight());
        this.game.batch.draw(this.QuestI, this.QbtnGolosProtiv.getX(), this.QbtnGolosProtiv.getY(), this.QbtnGolosProtiv.getWidth(), this.QbtnGolosProtiv.getHeight());
        this.game.batch.draw(this.QuestI, this.QbtnGameStyle.getX(), this.QbtnGameStyle.getY(), this.QbtnGameStyle.getWidth(), this.QbtnGameStyle.getHeight());
        this.wait.draw(this.game.batch, 1.0F);
        this.wait.act(Gdx.graphics.getDeltaTime());
        this.message.draw(this.game.batch, 1.0F);
        this.message.act(Gdx.graphics.getDeltaTime());
        this.container.draw(this.game.batch, 1.0F);
        this.container.act(Gdx.graphics.getDeltaTime());
        MyGame var10 = this.game.game;
        Array var11 = MyGame.stage.getActors();
        MyGame var8 = this.game.game;
        if (var11.contains(MyGame.PlayerInfo, true)) {
            var10 = this.game.game;
            MyGame.PlayerInfo.draw(this.game.batch, 1.0F);
            var10 = this.game.game;
            MyGame.PlayerInfo.act(Gdx.graphics.getDeltaTime());
        }

        var10 = this.game.game;
        var11 = MyGame.stage.getActors();
        var8 = this.game.game;
        if (var11.contains(MyGame.PlayerInfoPaint, true)) {
            var10 = this.game.game;
            MyGame.PlayerInfoPaint.draw(this.game.batch, 1.0F);
            var10 = this.game.game;
            MyGame.PlayerInfoPaint.act(Gdx.graphics.getDeltaTime());
        }

        var10 = this.game.game;
        var11 = MyGame.stage.getActors();
        var8 = this.game.game;
        if (var11.contains(MyGame.AgreeInfo, true)) {
            var10 = this.game.game;
            MyGame.AgreeInfo.draw(this.game.batch, 1.0F);
            var10 = this.game.game;
            MyGame.AgreeInfo.act(Gdx.graphics.getDeltaTime());
        }

        this.game.batch.end();
    }

    public void resize(int var1, int var2) {
    }

    public void resume() {
    }

    public void show() {
        Incognito = true;
        this.setScreen = true;
        if (TableInRoomScreen.getInstance(this.game).isStartSearch()) {
            MainMenuScreen.Connect_Class.socket.emit("RemoveSearcher", new Object[0]);
            TableInRoomScreen.getInstance(this.game).btnStartSearch.setDisabled(true);
        }

        Setting.numberMafia = 1;
        Setting.numberMafia_real = 1;
        Setting.numberPlayer = 5;
        Setting.restart();
        this.btnMed.setTouchable(Touchable.enabled);
        this.btnMed.setChecked(false);
        this.btnSherif.setTouchable(Touchable.enabled);
        this.btnSherif.setChecked(false);
        this.btnManiac.setTouchable(Touchable.enabled);
        this.btnManiac.setChecked(false);
        this.btnDon.setTouchable(Touchable.enabled);
        this.btnDon.setChecked(false);
        this.btnPutana.setTouchable(Touchable.enabled);
        this.btnPutana.setChecked(false);
        this.btnBessmert.setTouchable(Touchable.enabled);
        this.btnBessmert.setChecked(false);
        this.btnTwoface.setTouchable(Touchable.enabled);
        this.btnTwoface.setChecked(false);
        this.btnVor.setTouchable(Touchable.enabled);
        this.btnVor.setChecked(false);
        this.wait = new Image();
        this.wait.setX(370.0F);
        this.wait.setY(287.0F);
        this.wait.setWidth(60.0F);
        this.wait.setHeight(60.0F);
        this.btnGo.setTouchable(Touchable.enabled);
        this.KolRolei = 1;
        this.R = 0.0F;
        this.Rc1 = 0.0F;
        this.Rc2 = 0.0F;
        this.Rc3 = 0.0F;
        this.Rc4 = 0.0F;
        this.Rc5 = 0.0F;
        this.Rc6 = 0.0F;
        this.Rc7 = 0.0F;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800.0F, 480.0F);
        this.viewport = new StretchViewport(800.0F, 480.0F, this.camera);
        MyGame.stage = new MafiaStage(this.viewport, this.game.batch);
        Gdx.input.setInputProcessor(MyGame.stage);
        MyGame.stage.addActor(this.btnGo);
        MyGame.stage.addActor(this.btnGameStyle);
        MyGame.stage.addActor(this.btnGolosProtiv);
        MyGame.stage.addActor(this.btnPlus);
        MyGame.stage.addActor(this.btnMinus);
        MyGame.stage.addActor(this.btnPlusM);
        MyGame.stage.addActor(this.btnMinusM);
        MyGame.stage.addActor(this.QbtnGolosProtiv);
        MyGame.stage.addActor(this.QbtnGameStyle);
        MyGame.stage.addActor(this.btnBack);
        MyGame.stage.addActor(this.container);
        this.loadmusic();
        Iterator var1 = MyGame.stage.getActors().iterator();

        while(var1.hasNext()) {
            ((Actor)var1.next()).setTouchable(Touchable.enabled);
        }

        switch (this.game.rooms.Role) {
            case 3:
                this.btnMed.setTouchable(Touchable.disabled);
                this.btnMed.setChecked(true);
                Setting.med = true;
                Setting.med_real = true;
                ++this.KolRolei;
                break;
            case 4:
                this.btnSherif.setTouchable(Touchable.disabled);
                this.btnSherif.setChecked(true);
                Setting.sherif = true;
                Setting.sherif_real = true;
                ++this.KolRolei;
                break;
            case 5:
                this.btnManiac.setTouchable(Touchable.disabled);
                this.btnManiac.setChecked(true);
                Setting.maniac = true;
                Setting.maniac_real = true;
                ++this.KolRolei;
                break;
            case 6:
                this.btnDon.setTouchable(Touchable.disabled);
                this.btnDon.setChecked(true);
                Setting.don = true;
                Setting.don_real = true;
                --Setting.numberMafia;
                --Setting.numberMafia_real;
                ++this.KolRolei;
                break;
            case 7:
                this.btnPutana.setTouchable(Touchable.disabled);
                this.btnPutana.setChecked(true);
                Setting.putana = true;
                Setting.putana_real = true;
                ++this.KolRolei;
                break;
            case 8:
                this.btnBessmert.setTouchable(Touchable.disabled);
                this.btnBessmert.setChecked(true);
                Setting.bessmert = true;
                Setting.bessmert_real = true;
                ++this.KolRolei;
                break;
            case 9:
                this.btnTwoface.setTouchable(Touchable.disabled);
                this.btnTwoface.setChecked(true);
                Setting.twoface = 1;
                Setting.twoface_real = 1;
                Setting.numberPlayer = 7;
                ++this.KolRolei;
                break;
            case 10:
                this.btnVor.setTouchable(Touchable.disabled);
                this.btnVor.setChecked(true);
                Setting.vor = true;
                Setting.vor_real = true;
                ++this.KolRolei;
        }

        if (Setting.don) {
            ++this.KolRolei;
        }

        if (Setting.med) {
            ++this.KolRolei;
        }

        if (Setting.putana) {
            ++this.KolRolei;
        }

        if (Setting.maniac) {
            ++this.KolRolei;
        }

        if (Setting.sherif) {
            ++this.KolRolei;
        }

        if (Setting.bessmert) {
            ++this.KolRolei;
        }

        if (Setting.twoface != 0) {
            ++this.KolRolei;
        }

    }

    public void waitScreen(String var1) {
        if (this.game.getScreen().equals(this.game.sett)) {
            this.setScreen = false;
            this.wait.removeAction((Action)this.wait.getActions().get(0));
            this.wait.setDrawable((Drawable)null);
            WaitPlayers.numberPlayers = Setting.numberPlayer;
            WaitPlayers.numberPlayersInRoom = 1;
            WaitPlayers.RoomID = var1;
            this.game.setScreen(this.game.wait);
            this.btnGo.setTouchable(Touchable.enabled);
        } else {
            this.game.rooms.wait.removeAction((Action)this.game.rooms.wait.getActions().get(0));
            Sett var2 = this.game.sett;
            Incognito = false;
            WaitClassic var5 = this.game.waitClassic;
            WaitClassic.numberPlayers = Setting.numberPlayer;
            var5 = this.game.waitClassic;
            WaitClassic.numberPlayersInRoom = 1;
            var5 = this.game.waitClassic;
            WaitClassic.RoomID = var1;
            this.game.setScreen(this.game.waitClassic);
            this.game.rooms.container.setTouchable(Touchable.enabled);
            RoomsScreen var3 = this.game.rooms;
            Label var4 = new Label(RoomsScreen.Name, this.game.game.skin, "chatAuthtor");
            this.game.waitClassic.PersonTable.row();
            this.game.waitClassic.PersonTable.add(var4).padTop(5.0F).center();
        }

    }

    class Back_toStart_Listner extends InputListener {
        final Sett this$0;

        Back_toStart_Listner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            this.this$0.setScreen = false;
            this.this$0.game.setScreen(this.this$0.game.rooms);
            return true;
        }
    }

    class BessmertListn extends ClickListener {
        final Sett this$0;

        BessmertListn(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            IActivityRequestHandler var4;
            Mafia var7;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.BessmertBuy != 0) {
                    if (!Setting.vor) {
                        Sett var6;
                        if (!Setting.bessmert) {
                            if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                                this.this$0.btnBessmert.setChecked(false);
                            } else if ((Setting.numberPlayer > 6 || Setting.don_real || !Setting.med_real) && (Setting.numberPlayer > 6 || Setting.don_real || !Setting.sherif_real) && (Setting.numberPlayer > 6 || Setting.don_real || !Setting.putana_real)) {
                                Setting.bessmert = true;
                                Setting.bessmert_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            } else {
                                this.this$0.btnBessmert.setChecked(false);
                            }
                        } else {
                            Setting.bessmert = false;
                            Setting.bessmert_real = false;
                            var6 = this.this$0;
                            --var6.KolRolei;
                        }
                    } else {
                        this.this$0.btnBessmert.setChecked(false);
                        var4 = this.this$0.game.getHandler();
                        var7 = this.this$0.game;
                        var4.toast(Mafia.local.get("bessmert_and_vor_cannot_play"));
                    }
                } else {
                    this.this$0.btnBessmert.setChecked(false);
                    var4 = this.this$0.game.getHandler();
                    var7 = this.this$0.game;
                    var4.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnBessmert.setChecked(false);
                var4 = this.this$0.game.getHandler();
                var7 = this.this$0.game;
                var4.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class DonListn extends ClickListener {
        final Sett this$0;

        DonListn(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.DonBuy != 0) {
                    Sett var6;
                    if (!Setting.don) {
                        if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                            this.this$0.btnDon.setChecked(false);
                        } else if (this.this$0.game.rooms.Role == 1 && Setting.numberMafia - 1 == 0) {
                            this.this$0.btnDon.setChecked(false);
                        } else {
                            Setting.don = true;
                            Setting.don_real = true;
                            var6 = this.this$0;
                            ++var6.KolRolei;
                            --Setting.numberMafia;
                            --Setting.numberMafia_real;
                        }
                    } else {
                        Setting.don = false;
                        Setting.don_real = false;
                        var6 = this.this$0;
                        --var6.KolRolei;
                        ++Setting.numberMafia;
                        ++Setting.numberMafia_real;
                    }
                } else {
                    this.this$0.btnDon.setChecked(false);
                    IActivityRequestHandler var4 = this.this$0.game.getHandler();
                    Mafia var7 = this.this$0.game;
                    var4.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnDon.setChecked(false);
                IActivityRequestHandler var8 = this.this$0.game.getHandler();
                Mafia var9 = this.this$0.game;
                var8.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class GameStyleListner extends InputListener {
        final Sett this$0;

        GameStyleListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            switch (Setting.game_style) {
                case 0:
                    Setting.game_style = 2;
                    break;
                case 1:
                    Setting.game_style = 0;
                    break;
                case 2:
                    Setting.game_style = 1;
            }

            return true;
        }
    }

    class GoListner extends InputListener {
        final Sett this$0;

        GoListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            Iterator var7 = MyGame.stage.getActors().iterator();

            while(var7.hasNext()) {
                ((Actor)var7.next()).setTouchable(Touchable.disabled);
            }

            this.this$0.wait.setDrawable(this.this$0.game.rooms.skin, "cursor");
            this.this$0.wait.setOrigin(25.0F, 25.0F);
            this.this$0.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
            this.this$0.btnGo.setTouchable(Touchable.disabled);

            RoomsScreen.MyTextInputListener var8 = this.this$0.game.rooms.new MyTextInputListener(this.this$0.game.rooms);
            Input var6 = Gdx.input;
            String var9 = Mafia.local.get("name_of_server");
            var6.getTextInput(var8, var9, "", Mafia.local.get("enter_name_of_server"));

            return true;
        }
    }

    class GolosProtivListner extends InputListener {
        final Sett this$0;

        GolosProtivListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (!Sett.Incognito) {
                Sett.Incognito = true;
            } else {
                Sett.Incognito = false;
            }

            return true;
        }
    }

    class KartListner extends InputListener {
        final Sett this$0;

        KartListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (!Setting.kart) {
                Setting.kart = true;
            } else {
                Setting.kart = false;
            }

            return true;
        }
    }

    class ManiacListner extends ClickListener {
        final Sett this$0;

        ManiacListner(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.ManiacBuy != 0) {
                    Sett var6;
                    if (!Setting.maniac) {
                        if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                            this.this$0.btnManiac.setChecked(false);
                        } else {
                            Setting.maniac = true;
                            Setting.maniac_real = true;
                            var6 = this.this$0;
                            ++var6.KolRolei;
                        }
                    } else {
                        Setting.maniac = false;
                        Setting.maniac_real = false;
                        var6 = this.this$0;
                        --var6.KolRolei;
                    }
                } else {
                    this.this$0.btnManiac.setChecked(false);
                    IActivityRequestHandler var7 = this.this$0.game.getHandler();
                    Mafia var4 = this.this$0.game;
                    var7.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnManiac.setChecked(false);
                IActivityRequestHandler var9 = this.this$0.game.getHandler();
                Mafia var8 = this.this$0.game;
                var9.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class MedListner extends ClickListener {
        final Sett this$0;

        MedListner(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            IActivityRequestHandler var4;
            Mafia var7;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.MedBuy != 0) {
                    if ((!Setting.putana || Setting.numberPlayer < 15) && Setting.putana) {
                        this.this$0.btnMed.setChecked(false);
                        var4 = this.this$0.game.getHandler();
                        var7 = this.this$0.game;
                        var4.toast(Mafia.local.get("putana_and_doc_cannot_play"));
                    } else {
                        Sett var6;
                        if (!Setting.med) {
                            if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                                this.this$0.btnMed.setChecked(false);
                            } else if (Setting.numberPlayer <= 6 && !Setting.don_real && Setting.bessmert_real) {
                                this.this$0.btnMed.setChecked(false);
                            } else if (Setting.numberPlayer == 5) {
                                if (this.this$0.KolRolei < 2) {
                                    Setting.med = true;
                                    Setting.med_real = true;
                                    var6 = this.this$0;
                                    ++var6.KolRolei;
                                } else {
                                    this.this$0.btnMed.setChecked(false);
                                }
                            } else if (Setting.numberPlayer == 6 && Setting.numberMafia_real == 1) {
                                if (this.this$0.KolRolei < 2) {
                                    Setting.med = true;
                                    Setting.med_real = true;
                                    var6 = this.this$0;
                                    ++var6.KolRolei;
                                } else {
                                    this.this$0.btnMed.setChecked(false);
                                }
                            } else {
                                Setting.med = true;
                                Setting.med_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            }
                        } else {
                            Setting.med = false;
                            Setting.med_real = false;
                            var6 = this.this$0;
                            --var6.KolRolei;
                        }
                    }
                } else {
                    this.this$0.btnMed.setChecked(false);
                    var4 = this.this$0.game.getHandler();
                    var7 = this.this$0.game;
                    var4.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnMed.setChecked(false);
                var4 = this.this$0.game.getHandler();
                var7 = this.this$0.game;
                var4.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class MinusListner extends InputListener {
        final Sett this$0;

        MinusListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (Setting.numberPlayer != 5 && Setting.numberPlayer - Setting.numberMafia > this.this$0.KolRolei && (Setting.numberPlayer > 7 || Setting.twoface_real == 0)) {
                --Setting.numberPlayer;
                byte var8 = (byte) (Setting.don_real  ? 1 : 0);
                byte var7;
                if (Setting.twoface_real != 0) {
                    var7 = 1;
                } else {
                    var7 = 0;
                }

                if (Setting.numberPlayer < 15 && Setting.putana && Setting.med) {
                    if (this.this$0.game.rooms.Role != 3) {
                        Setting.med = false;
                        Setting.med_real = false;
                        this.this$0.btnMed.setChecked(false);
                    } else {
                        Setting.putana = false;
                        Setting.putana_real = false;
                        this.this$0.btnPutana.setChecked(false);
                    }
                }

                if (Setting.numberPlayer != 6 && Setting.numberPlayer != 5) {
                    Setting.numberMafia = Setting.numberPlayer / 3 - var8 - var7;
                    Setting.numberMafia_real = Setting.numberPlayer / 3 - var8 - var7;
                } else {
                    var4 = 1 - var8 - var7;
                    Setting.numberMafia = var4;
                    Setting.numberMafia_real = var4;
                    Sett var6;
                    if (Setting.med_real && this.this$0.game.rooms.Role != 3) {
                        var6 = this.this$0;
                        --var6.KolRolei;
                        Setting.med = false;
                        Setting.med_real = false;
                    }

                    if (Setting.sherif_real && this.this$0.game.rooms.Role != 4) {
                        var6 = this.this$0;
                        --var6.KolRolei;
                        Setting.sherif = false;
                        Setting.sherif_real = false;
                    }

                    if (Setting.bessmert_real && this.this$0.game.rooms.Role != 8) {
                        var6 = this.this$0;
                        --var6.KolRolei;
                        Setting.bessmert = false;
                        Setting.bessmert_real = false;
                    }

                    if (Setting.putana_real && this.this$0.game.rooms.Role != 7) {
                        var6 = this.this$0;
                        --var6.KolRolei;
                        Setting.putana = false;
                        Setting.putana_real = false;
                    }
                }
            }

            return true;
        }
    }

    class MinusMListner extends InputListener {
        final Sett this$0;

        MinusMListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (Setting.numberMafia > 1 && (!((double)Setting.numberMafia < (double)Setting.numberPlayer / 3.0) || Setting.don_real) && (Setting.numberMafia != 2 || Setting.numberPlayer != 7 || Setting.don_real) && (Setting.numberMafia != 2 || Setting.numberPlayer != 8 || Setting.don_real) && (Setting.numberMafia != 3 || Setting.numberPlayer < 9 || Setting.don_real) && (Setting.numberMafia != 2 || Setting.numberPlayer < 9 || !Setting.don_real) && (Setting.numberMafia_real > 1 || Setting.twoface_real == 0)) {
                byte var6 = 0;
                byte var7 = (byte) (Setting.don_real ? 1 : 0);
                if (Setting.twoface_real != 0) {
                    var6 = 1;
                }

                if (!((double)(Setting.numberMafia + var7 + var6 + 1) > (double)Setting.numberPlayer / 3.0)) {
                    --Setting.numberMafia;
                    --Setting.numberMafia_real;
                }
            }

            return true;
        }
    }

    class PlusListner extends InputListener {
        final Sett this$0;

        PlusListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (Setting.numberPlayer != 20) {
                ++Setting.numberPlayer;
                byte var6 = 0;
                byte var7 = (byte) (Setting.don_real ? 1 : 0);
                if (Setting.twoface_real != 0) {
                    var6 = 1;
                }

                if (Setting.numberPlayer == 6) {
                    var4 = 1 - var7 - var6;
                    Setting.numberMafia = var4;
                    Setting.numberMafia_real = var4;
                } else {
                    Setting.numberMafia = Setting.numberPlayer / 3 - var7 - var6;
                    Setting.numberMafia_real = Setting.numberPlayer / 3 - var7 - var6;
                }
            }

            return true;
        }
    }

    class PlusMListner extends InputListener {
        final Sett this$0;

        PlusMListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            byte var7 = (byte) (Setting.don_real ? 1 : 0);
            byte var6;
            if (Setting.twoface_real != 0) {
                var6 = 1;
            } else {
                var6 = 0;
            }

            if (!((double)(Setting.numberMafia + var7 + var6 + 1) > (double)Setting.numberPlayer / 3.0) && Setting.numberPlayer - Setting.numberMafia > this.this$0.KolRolei) {
                ++Setting.numberMafia;
                ++Setting.numberMafia_real;
            }

            return true;
        }
    }

    class PutanaListn extends ClickListener {
        final Sett this$0;

        PutanaListn(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            Mafia var4;
            IActivityRequestHandler var7;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.PutanaBuy != 0) {
                    if ((!Setting.med || Setting.numberPlayer < 15) && Setting.med) {
                        this.this$0.btnPutana.setChecked(false);
                        var7 = this.this$0.game.getHandler();
                        var4 = this.this$0.game;
                        var7.toast(Mafia.local.get("putana_and_doc_cannot_play"));
                    } else {
                        Sett var6;
                        if (!Setting.putana) {
                            if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                                this.this$0.btnPutana.setChecked(false);
                            } else if (Setting.numberPlayer == 5) {
                                if (this.this$0.KolRolei < 2) {
                                    Setting.putana = true;
                                    Setting.putana_real = true;
                                    var6 = this.this$0;
                                    ++var6.KolRolei;
                                } else {
                                    this.this$0.btnPutana.setChecked(false);
                                }
                            } else {
                                Setting.putana = true;
                                Setting.putana_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            }
                        } else {
                            Setting.putana = false;
                            Setting.putana_real = false;
                            var6 = this.this$0;
                            --var6.KolRolei;
                        }
                    }
                } else {
                    this.this$0.btnPutana.setChecked(false);
                    var7 = this.this$0.game.getHandler();
                    var4 = this.this$0.game;
                    var7.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnPutana.setChecked(false);
                var7 = this.this$0.game.getHandler();
                var4 = this.this$0.game;
                var7.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class QBessmertListn extends InputListener {
        final Sett this$0;

        QBessmertListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 11;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QDonListn extends InputListener {
        final Sett this$0;

        QDonListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 6;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QGameStyleListn extends InputListener {
        final Sett this$0;

        QGameStyleListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 10;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QGolosProtivListn extends InputListener {
        final Sett this$0;

        QGolosProtivListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 9;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QKartaListn extends InputListener {
        final Sett this$0;

        QKartaListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 8;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QManiacListner extends InputListener {
        final Sett this$0;

        QManiacListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 5;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    public final class QMedListner extends InputListener {
        final Sett this$0;

        public QMedListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 3;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QPutanaListn extends InputListener {
        final Sett this$0;

        QPutanaListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 7;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QSherifListner extends InputListener {
        final Sett this$0;

        QSherifListner(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 4;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QTwofaceListn extends InputListener {
        final Sett this$0;

        QTwofaceListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 12;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class QVorListn extends InputListener {
        final Sett this$0;

        QVorListn(Sett var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 13;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    class SherifListner extends ClickListener {
        final Sett this$0;

        SherifListner(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            Mafia var4;
            IActivityRequestHandler var7;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.SherifBuy != 0) {
                    Sett var6;
                    if (!Setting.sherif) {
                        if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                            this.this$0.btnSherif.setChecked(false);
                        } else if (Setting.numberPlayer == 5) {
                            if (this.this$0.KolRolei < 2) {
                                Setting.sherif = true;
                                Setting.sherif_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            } else {
                                this.this$0.btnSherif.setChecked(false);
                            }
                        } else if (Setting.numberPlayer == 6 && Setting.numberMafia_real == 1) {
                            if (this.this$0.KolRolei < 2) {
                                Setting.sherif = true;
                                Setting.sherif_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            } else {
                                this.this$0.btnSherif.setChecked(false);
                            }
                        } else {
                            Setting.sherif = true;
                            Setting.sherif_real = true;
                            var6 = this.this$0;
                            ++var6.KolRolei;
                        }
                    } else {
                        Setting.sherif = false;
                        Setting.sherif_real = false;
                        var6 = this.this$0;
                        --var6.KolRolei;
                    }
                } else {
                    this.this$0.btnSherif.setChecked(false);
                    var7 = this.this$0.game.getHandler();
                    var4 = this.this$0.game;
                    var7.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnSherif.setChecked(false);
                var7 = this.this$0.game.getHandler();
                var4 = this.this$0.game;
                var7.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class TwofaceListn extends ClickListener {
        final Sett this$0;

        TwofaceListn(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.TwoFaceBuy != 0) {
                    Sett var6;
                    if (Setting.twoface == 0) {
                        if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                            this.this$0.btnTwoface.setChecked(false);
                        } else if (Setting.numberMafia_real >= 2) {
                            Setting.twoface = 1;
                            Setting.twoface_real = 1;
                            var6 = this.this$0;
                            ++var6.KolRolei;
                            --Setting.numberMafia;
                            --Setting.numberMafia_real;
                        } else {
                            this.this$0.btnTwoface.setChecked(false);
                        }
                    } else {
                        Setting.twoface = 0;
                        Setting.twoface_real = 0;
                        var6 = this.this$0;
                        --var6.KolRolei;
                        ++Setting.numberMafia;
                        ++Setting.numberMafia_real;
                    }
                } else {
                    this.this$0.btnTwoface.setChecked(false);
                    IActivityRequestHandler var7 = this.this$0.game.getHandler();
                    Mafia var4 = this.this$0.game;
                    var7.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnTwoface.setChecked(false);
                IActivityRequestHandler var9 = this.this$0.game.getHandler();
                Mafia var8 = this.this$0.game;
                var9.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }

    class VorListn extends ClickListener {
        final Sett this$0;

        VorListn(Sett var1) {
            this.this$0 = var1;
        }

        public void clicked(InputEvent var1, float var2, float var3) {
            super.clicked(var1, var2, var3);
            RoomsScreen var5 = this.this$0.game.rooms;
            IActivityRequestHandler var8;
            Mafia var9;
            if (RoomsScreen.MMR >= 30) {
                if (this.this$0.game.rooms.VorBuy != 0) {
                    if (!Setting.bessmert) {
                        Sett var6;
                        if (!Setting.vor) {
                            if (Setting.numberPlayer - Setting.numberMafia <= this.this$0.KolRolei) {
                                this.this$0.btnVor.setChecked(false);
                            } else {
                                Setting.vor = true;
                                Setting.vor_real = true;
                                var6 = this.this$0;
                                ++var6.KolRolei;
                            }
                        } else {
                            Setting.vor = false;
                            Setting.vor_real = false;
                            var6 = this.this$0;
                            --var6.KolRolei;
                        }
                    } else {
                        this.this$0.btnVor.setChecked(false);
                        IActivityRequestHandler var4 = this.this$0.game.getHandler();
                        Mafia var7 = this.this$0.game;
                        var4.toast(Mafia.local.get("bessmert_and_vor_cannot_play"));
                    }
                } else {
                    this.this$0.btnVor.setChecked(false);
                    var8 = this.this$0.game.getHandler();
                    var9 = this.this$0.game;
                    var8.toast(Mafia.local.get("you_can_add_only_open_role"));
                }
            } else {
                this.this$0.btnVor.setChecked(false);
                var8 = this.this$0.game.getHandler();
                var9 = this.this$0.game;
                var8.toast(Mafia.local.get("you_can_add_only_mafia"));
            }

        }
    }
}
