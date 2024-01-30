package com.kartuzov.mafiaonline;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.kartuzov.mafiaonline.Actor.IconRole;
import com.kartuzov.mafiaonline.ChestReward.CatChest.ChestInfo;
import com.kartuzov.mafiaonline.ChestReward.CatChest.RoleSkins;
import com.kartuzov.mafiaonline.ChestReward.CatChest.SkinTexture;
import com.kartuzov.mafiaonline.ChestReward.NingaChest.NingaChestInfo;
import com.kartuzov.mafiaonline.ChestReward.OpenChest.OpenCatChest;
import com.kartuzov.mafiaonline.ChestReward.OpenChest.OpenChest;
import com.kartuzov.mafiaonline.ChestReward.OpenChest.OpenNingaChest;
import com.kartuzov.mafiaonline.ChestReward.OpenChest.OpenVampChest;
import com.kartuzov.mafiaonline.ChestReward.VampChest.VampChestInfo;
import com.kartuzov.mafiaonline.Clubs.FunctionOfWindow;
import com.kartuzov.mafiaonline.Clubs.WindowDefault;
import com.kartuzov.mafiaonline.Clubs.WindowScrollPolici;
import com.kartuzov.mafiaonline.GlobalMessages.RewardTask;
import com.kartuzov.mafiaonline.Help.HelpWindow;
import com.kartuzov.mafiaonline.Task.TakInShkaf;
import com.kartuzov.mafiaonline.Task.Task;
import com.kartuzov.mafiaonline.WindowINRoomScreen.TableRoleDescription;
import com.kartuzov.mafiaonline.WindowINRoomScreen.TaskScreen;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowAddEmail;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowAlotofDislike;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowChangeNick;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowChangePassword;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowCheckMail;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowColorNick;
import com.kartuzov.mafiaonline.WindowINRoomScreen.WindowOfferToReturn;
import com.kartuzov.mafiaonline.WindowINRoomScreen.MatchMaking.TableInRoomScreen;
import com.kartuzov.mafiaonline.WindowINRoomScreen.UpdateWindows.WindowUpdateNinga;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("GDXJavaInvalidPropertyKey")
public class RoomsScreen implements Screen {
    static String FriendToSend;
    public static boolean GeorgLent;
    public static int JunRangHat;
    public static boolean LowRate;
    public static int MMR;
    public static int Mod;
    static int MyRating;
    public static String Name;
    static String Name_of_server;
    public static String Number;
    public static int OldMMR;
    public static int VIP;
    public static JSONArray allServers;
    static HashMap<String, ArrayList<Message>> arMessagesFromFriend = new HashMap();
    public static double countLose;
    public static double countWin;
    public static int hat;
    public static boolean isInstaHat;
    public static int medal;
    public static int numberDisLike;
    public static int numberLike;
    public static int numberOfOpinion;
    public static String partyName;
    public static String pass;
    public Table AcessToClassik;
    public Image ActualShirt;
    public Table BackgroundSkroll;
    public int BessmertBuy;
    ParticleEffect ChangeMode;
    public Sound ChangeModeSound;
    public boolean ChangeNick = false;
    public boolean ColorNick = false;
    public TextButton Create;
    public int DonBuy;
    ParticleEffect FireEffect;
    public Window FriendWindow;
    public Button Friends;
    public Image GreyI;
    public Image GreyIAgree;
    Window GreyIMessage;
    Image GreyIinvite;
    public boolean HatAmericaBuy = false;
    public boolean HatBabyBuy = false;
    public boolean HatBantBuy = false;
    public boolean HatCrownBuy = false;
    public boolean HatGopnikBuy = false;
    public boolean HatJapan1 = false;
    public boolean HatJapan2 = false;
    public boolean HatJapan3 = false;
    public boolean HatMilitaryBuy = false;
    public boolean HatPirateBuy = false;
    public boolean HatPolosBuy = false;
    public boolean HatSambreroBuy = false;
    public boolean HatSantaBuy = false;
    public boolean HatUshankaBuy = false;
    public boolean HatVIPCrownBuy = false;
    public boolean HatWitchBuy = false;
    public boolean InFindRooms;
    Window InviteToFriendship;
    public Label LabelMoney;
    public int LastSpeech = 0;
    public Table LastSpeechPurchase;
    public Sound LastSpeechSound;
    ParticleEffect LvlUpClassic;
    public Sound LvlUpClassicSound;
    public int MMRclassic = -1;
    public int MafiaBuy;
    public Sound MafiaLoseSound;
    public Sound MafiaWinSound;
    public int ManiacBuy;
    public Sound ManiacLoseSound;
    public Sound ManiacWinSound;
    public int MaxMMr;
    public int MedBuy;
    FriendMessage MessageFromFriend;
    public int MirnBuy;
    public Sound MirnieLoseSound;
    public Sound MirnieWinSound;
    public String MyFriends;
    public Image NextRole;
    public int NingaBuy;
    public Table NormPotion;
    public int NormPotionCount = 0;
    public boolean NotvisibleNumber = false;
    public Label NumberOnline;
    public ParticleEffect OpenChestEffect;
    public boolean PasswordBuy = false;
    public Image PasswordClassic;
    boolean PodhoditRole;
    public Sound PrigressSound;
    public Image PriviousRole;
    ParticleEffect PufEffect;
    public int PutanaBuy;
    Image RangHat = null;
    public Image RefreshPercent;
    public Sound RegressSound;
    public int Role = 2;
    public boolean SeeRang = false;
    public int SherifBuy;
    final Button Shkaf;
    ParticleEffect SmokEffect;
    public boolean SuperAccessToClassic = false;
    public Task Task1;
    public Task Task2;
    public Task Task3;
    public int TwoFaceBuy;
    public int VampBuy;
    public Table VipPotion;
    public int VipPotionCount = 0;
    public Image Vipticket;
    public int VorBuy;
    public Sound WinLose;
    public int XYZ;
    public HashMap<Integer, String> actualSkins = new HashMap();
    public Window agreeMagazin;
    public Animation animHandRole;
    public ArrayList<String> arClassicServerToJoin;
    public ArrayList<Integer> arMafiaRole;
    public ArrayList<Integer> arPaints;
    public ArrayList<Integer> arRoles;
    public ImageButton btnChestInfo;
    public TextButton btnFindMatch;
    public ImageButton btnNingaChestInfo;
    public TextButton btnSelectMatch;
    public ImageButton btnVampChestInfo;
    OrthographicCamera camera;
    int chooseSkin = 0;
    public String colorNick = "[#ffff80]";
    public Table container;
    public int countAcessToClassik = 0;
    public int countChest;
    public int countNingaChest;
    public int countVampChest;
    public int curentMMr;
    float curentProgress;
    WindowAlotofDislike dislikeERR;
    Table friendTable;
    final Mafia game;
    public Image gameMaster;
    public Image hatAmerican;
    public Image hatBaby;
    public Image hatCrown;
    public Image hatObichn;
    public Image hatPolos;
    public Image hatSanta;
    public Image hatVIPCrown;
    public boolean haveBadge;
    public Window help;
    public ImageButton imgCatChest;
    public ImageButton imgCatChestFive;
    public ImageButton imgCatChestTen;
    public IconRole imgIconRole;
    public ImageButton imgMagazChangeNick;
    public ImageButton imgMagazColorNick;
    public ImageButton imgNingaChest;
    public ImageButton imgNingaChestFive;
    public ImageButton imgNingaChestTen;
    public ImageButton imgVampChest;
    public ImageButton imgVampChestFive;
    public ImageButton imgVampChestTen;
    public Sound knock;
    public Sound lastRang;
    public CreateServerListener listenerCreateServer;
    public StartSearchListener listenerStartSearch;
    Table madButton;
    public Window magazin;
    public Image magazinBandageForManiac;
    public String mail;
    public TextButton message;
    public Sound messageSound;
    ProgressBar mmr_bar;
    Label mmr_label;
    public ImageButton money100;
    public ImageButton money1000;
    public ImageButton money1350;
    public ImageButton money250;
    public ImageButton money400;
    public ImageButton money600;
    int moneyBonus;
    Sound moneySound;
    public Label name;
    public Sound newRang;
    Image oldRang;
    public float ostatokMMR = 0.0F;
    public String phone;
    public int progressBarStatus = 0;
    public Table purchasesScroll;
    Image rating;
    public String realName;
    public RewardTask rewardTask;
    public Window roleInfo;
    public OpenChest screenOpenChest;
    public ScrollPane scroll;
    ScrollPane scrollFriend;
    public ScrollPane scrollMagaz;
    public Window shkaf;
    public Stack shkafButton;
    public boolean showHelp = true;
    public Skin skin;
    public ArrayList<SkinTexture> skinBessmert;
    public ArrayList<SkinTexture> skinDoctor;
    public ArrayList<SkinTexture> skinDon;
    public ArrayList<SkinTexture> skinMafia;
    public ArrayList<SkinTexture> skinManiac;
    public ArrayList<SkinTexture> skinMirn;
    public ArrayList<SkinTexture> skinPutana;
    public ArrayList<SkinTexture> skinSherif;
    public ArrayList<SkinTexture> skinShirt;
    public ArrayList<SkinTexture> skinTwoFace;
    private Sound soundGarderodOpen;
    public Sound soundRewardTask;
    public MafiaStage stage;
    Table table;
    public TaskScreen taskScreen;
    public Image ticket;
    Viewport viewport;
    public int visionOfPaint = 0;
    public Image wait;
    Image waitFriend;
    public Image waitMagazin;
    public Window window;
    Window windowOfferToReturn;
    public WindowChangeNick wndChangeNick;
    public WindowChangePassword wndChangePassword;
    public WindowColorNick wndColorNick;

    public RoomsScreen(Mafia var1) {
        this.game = var1;
        this.arMafiaRole = new ArrayList();
        this.arClassicServerToJoin = new ArrayList();
        this.arMafiaRole.add(1);
        this.arMafiaRole.add(6);
        this.arMafiaRole.add(11);
        this.arMafiaRole.add(12);
        this.actualSkins.put(99, "Cart.jpg");
        this.arRoles = new ArrayList();
        this.arRoles.add(2);
        this.arRoles.add(1);
        this.arRoles.add(3);
        this.arRoles.add(4);
        this.arRoles.add(5);
        this.arRoles.add(6);
        this.arRoles.add(7);
        this.arRoles.add(8);
        this.arRoles.add(9);
        this.arRoles.add(10);
        this.arRoles.add(11);
        this.arRoles.add(12);
        this.newRang = Gdx.audio.newSound(Gdx.files.internal("Zvezdi.mp3"));
        this.soundGarderodOpen = Gdx.audio.newSound(Gdx.files.internal("garderob.mp3"));
        this.soundRewardTask = Gdx.audio.newSound(Gdx.files.internal("RewardTask.mp3"));
        this.lastRang = Gdx.audio.newSound(Gdx.files.internal("Vzmah.mp3"));
        this.WinLose = Gdx.audio.newSound(Gdx.files.internal("WinLose.mp3"));
        this.ChangeModeSound = Gdx.audio.newSound(Gdx.files.internal("ChangeMode.mp3"));
        this.PrigressSound = Gdx.audio.newSound(Gdx.files.internal("ProgressBar.mp3"));
        this.RegressSound = Gdx.audio.newSound(Gdx.files.internal("RegressBar.mp3"));
        this.LvlUpClassicSound = Gdx.audio.newSound(Gdx.files.internal("LvlUpClassic.mp3"));
        this.knock = Gdx.audio.newSound(Gdx.files.internal("knock.mp3"));
        this.messageSound = Gdx.audio.newSound(Gdx.files.internal("message.mp3"));
        this.MafiaLoseSound = Gdx.audio.newSound(Gdx.files.internal("MafiaLose.mp3"));
        this.MafiaWinSound = Gdx.audio.newSound(Gdx.files.internal("MafiaWin.mp3"));
        this.MirnieLoseSound = Gdx.audio.newSound(Gdx.files.internal("MirnieLose.mp3"));
        this.MirnieWinSound = Gdx.audio.newSound(Gdx.files.internal("MirnieWin.mp3"));
        this.ManiacLoseSound = Gdx.audio.newSound(Gdx.files.internal("ManiacLose.mp3"));
        this.ManiacWinSound = Gdx.audio.newSound(Gdx.files.internal("ManiacWin.mp3"));
        this.moneySound = Gdx.audio.newSound(Gdx.files.internal("TwoFaceSound.mp3"));
        this.LastSpeechSound = Gdx.audio.newSound(Gdx.files.internal("LastSpeechSound.mp3"));
        this.skin = this.game.game.skin;
        this.message = new TextButton("", this.skin, "message");
        this.message.setWidth(460.0F);
        this.message.setHeight(115.0F);
        this.message.setX(170.0F);
        this.message.setY(-140.0F);
        this.SmokEffect = new ParticleEffect();
        this.FireEffect = new ParticleEffect();
        this.PufEffect = new ParticleEffect();
        this.ChangeMode = new ParticleEffect();
        this.LvlUpClassic = new ParticleEffect();
        this.OpenChestEffect = new ParticleEffect();
        this.container = new Table();
        this.container.setHeight(480.0F);
        this.container.setWidth(800.0F);
        this.shkafButton = new Stack();
        this.NextRole = new Image(this.skin, "RightStrelka");
        this.NextRole.addListener(new InputListener() {
            public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                if (!TableInRoomScreen.getInstance(RoomsScreen.this.game).isStartSearch()) {
                    if (TableInRoomScreen.getInstance(RoomsScreen.this.game).isInParty()) {
                        RoomsScreen.this.tryToChangeRoleInParty(true);
                    } else if (RoomsScreen.this.arRoles.indexOf(RoomsScreen.this.Role) == RoomsScreen.this.arRoles.size() - 1) {
                        RoomsScreen.this.Role = (Integer)RoomsScreen.this.arRoles.get(0);
                    } else {
                        RoomsScreen.this.Role = (Integer)RoomsScreen.this.arRoles.get(RoomsScreen.this.arRoles.indexOf(RoomsScreen.this.Role) + 1);
                    }

                    RoomsScreen.this.imgIconRole.setHand(1);
                    if (RoomsScreen.this.updateIcon(RoomsScreen.this.Role) && !RoomsScreen.this.table.getChildren().contains(TableInRoomScreen.getInstance(RoomsScreen.this.game), true)) {
                        RoomsScreen.this.container.setTouchable(Touchable.disabled);
                        MainMenuScreen.Connect_Class.socket.emit("ListOfServers", new Object[0]);
                        RoomsScreen.this.wait.setOrigin(30.0F, 30.0F);
                        RoomsScreen.this.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                        RoomsScreen.this.Create.setDisabled(false);
                    } else {
                        MainMenuScreen.Connect_Class.socket.emit("NumberSearchersOfRole", new Object[]{RoomsScreen.this.Role});
                    }

                    new HelpWindow(RoomsScreen.this.game.rooms.stage, 19, RoomsScreen.this.rating, RoomsScreen.this.game);
                    if (RoomsScreen.Mod == 1) {
                        RoomsScreen.this.table.clear();
                    }
                }

                return true;
            }
        });
        this.PriviousRole = new Image(this.skin, "LeftStrelka");
        this.ActualShirt = new Image();
        Table var2 = new Table();
        var2.add(this.PriviousRole).expand().width(45.0F).height(50.0F);
        var2.add(this.ActualShirt).expand().width(35.0F).height(50.0F).padLeft(20.0F).padRight(20.0F);
        var2.add(this.NextRole).expand().width(45.0F).height(50.0F);
        this.PriviousRole.addListener(new InputListener() {
            public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                if (!TableInRoomScreen.getInstance(RoomsScreen.this.game).isStartSearch()) {
                    if (TableInRoomScreen.getInstance(RoomsScreen.this.game).isInParty()) {
                        RoomsScreen.this.tryToChangeRoleInParty(false);
                    } else if (RoomsScreen.this.arRoles.indexOf(RoomsScreen.this.Role) == 0) {
                        RoomsScreen.this.Role = (Integer)RoomsScreen.this.arRoles.get(RoomsScreen.this.arRoles.size() - 1);
                    } else {
                        RoomsScreen.this.Role = (Integer)RoomsScreen.this.arRoles.get(RoomsScreen.this.arRoles.indexOf(RoomsScreen.this.Role) - 1);
                    }

                    RoomsScreen.this.imgIconRole.setHand(2);
                    if (RoomsScreen.this.updateIcon(RoomsScreen.this.Role) && !RoomsScreen.this.table.getChildren().contains(TableInRoomScreen.getInstance(RoomsScreen.this.game), true)) {
                        RoomsScreen.this.container.setTouchable(Touchable.disabled);
                        MainMenuScreen.Connect_Class.socket.emit("ListOfServers", new Object[0]);
                        RoomsScreen.this.wait.setOrigin(30.0F, 30.0F);
                        RoomsScreen.this.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                        RoomsScreen.this.Create.setDisabled(false);
                    } else {
                        MainMenuScreen.Connect_Class.socket.emit("NumberSearchersOfRole", new Object[]{RoomsScreen.this.Role});
                    }

                    new HelpWindow(RoomsScreen.this.game.rooms.stage, 19, RoomsScreen.this.rating, RoomsScreen.this.game);
                    if (RoomsScreen.Mod == 1) {
                        RoomsScreen.this.table.clear();
                    }
                }

                return true;
            }
        });
        Table var3 = new Table();
        this.mmr_bar = new ProgressBar(0.0F, (float)this.MaxMMr, 1.0F, false, this.skin);
        this.mmr_bar.setAnimateDuration(2.0F);
        this.mmr_label = new Label("0/0", this.skin, "chat");
        var3.add(this.mmr_label);
        var3.row();
        var3.add(this.mmr_bar);
        TextButton var4 = new TextButton("х", this.skin, "login");
        var4.setChecked(true);
        var4.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                MyGame var6 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                Mafia var5 = RoomsScreen.this.game;
                MainMenuScreen var7 = Mafia.menu;
                MainMenuScreen.Connect_Class.socket.disconnect();
            }
        });
        this.imgIconRole = new IconRole();
        this.imgIconRole.addListener(new QListner(this));
        this.imgIconRole.setOrigin(75.0F, 100.0F);
        this.name = new Label(Name, this.skin);
        this.rating = new Image();
        Table var7 = new Table();
        var7.add(this.shkafButton).height(30.0F).width(30.0F);
        var7.add(this.name).colspan(2).width(80.0F).left();
        var7.row();
        var7.add(this.rating).height(70.0F).width(70.0F).center();
        var7.add(var3).colspan(2).left().padTop(5.0F).padBottom(5.0F);
        var7.row();
        var7.add(this.imgIconRole).colspan(3).width(140.0F).height(200.0F);
        var7.row().padTop(5.0F);
        var7.add(var2).center().colspan(3);
        this.Friends = new Button(this.skin.getDrawable("Friends_Button"));
        this.Friends.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                MyGame var5 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.WindowFriend(false);
            }
        });
        this.listenerCreateServer = new CreateServerListener(this);
        this.listenerStartSearch = new StartSearchListener(this);
        Mafia var10 = this.game;
        this.Create = new TextButton(Mafia.local.get("start_search"), this.game.game.skin, "login");
        this.Create.addListener(this.listenerStartSearch);
        this.table = new Table();
        this.scroll = new ScrollPane(this.table, this.skin);
        this.scroll.setScrollingDisabled(true, false);
        this.scroll.setVariableSizeKnobs(false);
        var10 = this.game;
        this.btnFindMatch = new TextButton(Mafia.local.get("find_room"), this.skin, "VkladkaInRoom");
        this.btnFindMatch.setChecked(true);
        this.btnFindMatch.setTouchable(Touchable.disabled);
        this.table.add(TableInRoomScreen.createInstance(this.game, this.Create));
        var10 = this.game;
        this.btnSelectMatch = new TextButton(Mafia.local.get("select_room"), this.skin, "VkladkaInRoom");
        this.btnSelectMatch.setChecked(false);
        this.BackgroundSkroll = new Table();
        this.BackgroundSkroll.add(this.btnFindMatch).width(250.0F).height(40.0F);
        this.BackgroundSkroll.add(this.btnSelectMatch).width(250.0F).height(40.0F);
        this.BackgroundSkroll.row();
        this.BackgroundSkroll.add(this.scroll).padBottom(16.0F).expand().fill().colspan(2);
        this.BackgroundSkroll.setBackground(this.skin.getDrawable("Table_rooms2"));
        this.btnFindMatch.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                Gdx.app.log("btnFindMatch", "click!");
                if (((TextButton)var2).isChecked()) {
                    RoomsScreen.this.btnSelectMatch.setChecked(false);
                    RoomsScreen.this.btnFindMatch.setTouchable(Touchable.disabled);
                    RoomsScreen.this.btnSelectMatch.setTouchable(Touchable.enabled);
                    RoomsScreen.this.ChangeMode = new ParticleEffect();
                    RoomsScreen.this.ChangeMode.load(Gdx.files.internal("particle/ChangeMode"), Gdx.files.internal(""));
                    RoomsScreen.this.ChangeMode.setPosition(500.0F, 280.0F);
                    RoomsScreen.this.ChangeMode.start();
                    Sound var9 = RoomsScreen.this.ChangeModeSound;
                    var9.play(MyGame.VOLUME);
                    TextButton var3 = RoomsScreen.this.Create;
                    var3.setText(Mafia.local.get("start_search"));
                    RoomsScreen.this.Create.removeListener(RoomsScreen.this.listenerCreateServer);
                    RoomsScreen.this.Create.addListener(RoomsScreen.this.listenerStartSearch);
                    RoomsScreen.this.table.clear();
                    RoomsScreen.this.table.add(TableInRoomScreen.getInstance(RoomsScreen.this.game));
                    RoomsScreen.this.wait.setDrawable(RoomsScreen.this.skin, "ZvezdaSerebro");
                    RoomsScreen.Mod = 0;
                    RoomsScreen.this.imgIconRole.setTouchable(Touchable.enabled);
                    RoomsScreen.this.PriviousRole.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.NextRole.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.ActualShirt.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.Role = 2;
                    RoomsScreen.this.updateIcon(RoomsScreen.this.Role);
                    RoomsScreen.this.rating.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.mmr_label.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.mmr_bar.addAction(Actions.sequence(Actions.visible(true), Actions.fadeIn(0.3F)));
                    RoomsScreen.this.PriviousRole.setTouchable(Touchable.enabled);
                    RoomsScreen.this.NextRole.setTouchable(Touchable.enabled);
                    RoomsScreen.this.BackgroundSkroll.addAction(Actions.sequence(Actions.fadeOut(0.2F), Actions.run(new Runnable() {
                        

                        public void run() {
                            RoomsScreen.this.BackgroundSkroll.setBackground(RoomsScreen.this.skin.getDrawable("Table_rooms2"));
                        }
                    }), Actions.fadeIn(0.2F)));
                }

            }
        });
        this.btnSelectMatch.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                Gdx.app.log("btnSelectMatch", "click!");
                if (((TextButton)var2).isChecked()) {
                    if (!TableInRoomScreen.getInstance(RoomsScreen.this.game).isInParty()) {
                        if (!TableInRoomScreen.getInstance(RoomsScreen.this.game).isStartSearch()) {
                            RoomsScreen.this.btnFindMatch.setChecked(false);
                            RoomsScreen.this.btnSelectMatch.setTouchable(Touchable.disabled);
                            RoomsScreen.this.btnFindMatch.setTouchable(Touchable.enabled);
                            RoomsScreen.this.ChangeMode = new ParticleEffect();
                            RoomsScreen.this.ChangeMode.load(Gdx.files.internal("particle/ChangeMode"), Gdx.files.internal(""));
                            RoomsScreen.this.ChangeMode.setPosition(500.0F, 280.0F);
                            RoomsScreen.this.ChangeMode.start();
                            Sound var9 = RoomsScreen.this.ChangeModeSound;
                            var9.play(MyGame.VOLUME);
                            TextButton var7 = RoomsScreen.this.Create;
                            var7.setText(Mafia.local.get("create_room"));
                            RoomsScreen.this.Create.removeListener(RoomsScreen.this.listenerStartSearch);
                            RoomsScreen.this.Create.addListener(RoomsScreen.this.listenerCreateServer);
                            RoomsScreen.this.table.clear();
                            RoomsScreen.this.wait.setDrawable(RoomsScreen.this.skin, "ZveadaGold");
                            RoomsScreen.this.PriviousRole.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.NextRole.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.ActualShirt.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.rating.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.mmr_label.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.mmr_bar.addAction(Actions.sequence(Actions.fadeOut(0.3F), Actions.visible(false)));
                            RoomsScreen.this.PriviousRole.setTouchable(Touchable.disabled);
                            RoomsScreen.this.NextRole.setTouchable(Touchable.disabled);

                            try {
                                if (RoomsScreen.this.isClassicAvailible()) {
                                    RoomsScreen.this.Create.setDisabled(false);
                                    Table var3 = RoomsScreen.this.BackgroundSkroll;
                                    AlphaAction var14 = Actions.fadeOut(0.2F);
                                    Runnable var8 = new Runnable() {
                                        public void run() {
                                            RoomsScreen.this.BackgroundSkroll.setBackground(RoomsScreen.this.skin.getDrawable("Table_roomsNew"));
                                        }
                                    };
                                    var3.addAction(Actions.sequence(var14, Actions.run(var8), Actions.fadeIn(0.2F)));
                                    IconRole var15 = RoomsScreen.this.imgIconRole;
                                    AlphaAction var10 = Actions.fadeOut(0.3F);
                                    SizeByAction var16 = Actions.sizeBy(50.0F, 67.0F);
                                    Runnable var4 = new Runnable() {
                                        public void run() {
                                            RoomsScreen.this.imgIconRole.setDrawable(RoomsScreen.this.skin, "Zvezda");
                                            RoomsScreen.Mod = 1;
                                            MainMenuScreen.Connect_Class.socket.emit("ListOfServers", new Object[0]);
                                        }
                                    };
                                    var15.addAction(Actions.sequence(var10, var16, Actions.run(var4), Actions.parallel(Actions.fadeIn(0.5F), Actions.sizeTo(150.0F, 200.0F), Actions.rotateBy(360.0F, 0.5F))));
                                } else {
                                    new HelpWindow(RoomsScreen.this.game.rooms.stage, 20, RoomsScreen.this.rating, RoomsScreen.this.game);
                                    RoomsScreen.this.Create.setDisabled(true);
                                    Table var12 = RoomsScreen.this.BackgroundSkroll;
                                    AlphaAction var17 = Actions.fadeOut(0.3F);
                                    Runnable var18 = new Runnable() {

                                        public void run() {
                                            RoomsScreen.this.BackgroundSkroll.setBackground(RoomsScreen.this.skin.getDrawable("Table_roomsNew_Close"));
                                        }
                                    };
                                    var12.addAction(Actions.sequence(var17, Actions.run(var18), Actions.fadeIn(0.3F)));
                                    IconRole var19 = RoomsScreen.this.imgIconRole;
                                    var17 = Actions.fadeOut(0.3F);
                                    SizeByAction var13 = Actions.sizeBy(50.0F, 67.0F);
                                    var18 = new Runnable() {
                                        public void run() {
                                            RoomsScreen.this.imgIconRole.setDrawable(RoomsScreen.this.skin, "ZvezdaClose");
                                            RoomsScreen.Mod = 1;
                                        }
                                    };
                                    var19.addAction(Actions.sequence(var17, var13, Actions.run(var18), Actions.parallel(Actions.fadeIn(0.5F), Actions.sizeTo(150.0F, 200.0F), Actions.rotateBy(360.0F, 0.5F))));
                                }
                            } catch (Exception var5) {
                            }
                        } else {
                            RoomsScreen.this.joinServerERR((JSONArray)null, 4);
                            RoomsScreen.this.btnSelectMatch.setChecked(false);
                        }
                    } else {
                        RoomsScreen.this.joinServerERR((JSONArray)null, 3);
                        RoomsScreen.this.btnSelectMatch.setChecked(false);
                    }
                }

            }
        });
        StringBuilder var11 = new StringBuilder();
        var11.append("");
        var11.append(this.XYZ);
        this.LabelMoney = new Label(var11.toString(), this.skin, "UiTextWhite");
        var10 = this.game;
        this.NumberOnline = new Label(Mafia.local.get("players_online"), this.skin, "UiTextWhite");
        var3 = new Table();
        var3.add(this.NumberOnline).center().pad(2.0F).padLeft(50.0F);
        var3.add(this.LabelMoney).right().padTop(2.0F).padBottom(5.0F).padLeft(20.0F);
        var3.add(new Image(this.skin, "money")).left().padTop(2.0F).padBottom(5.0F).padLeft(3.0F).width(25.0F).height(25.0F);
        var3.add(var4).right().height(35.0F).width(35.0F).pad(2.0F);
        var3.row();
        var3.add(this.BackgroundSkroll).colspan(4);
        this.table.defaults();
        this.table.left().top();
        this.wait = new Image(this.skin, "ZvezdaSerebro");
        Button var5 = new Button(this.skin.getDrawable("Magazin_Button"));
        var5.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                RoomsScreen.this.game.getHandler().LogEventFirebase(RoomsScreen.this.game.MAGAZIN_CLICK);
                RoomsScreen.this.WindowMagazin();
            }
        });
        Button var9 = new Button(this.skin.getDrawable("Top_Button"));
        var9.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                MyGame var5 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.game.setScreen(RoomsScreen.this.game.top);
                RoomsScreen.this.game.getHandler().LogEventFirebase(RoomsScreen.this.game.TOP_CLICK);
            }
        });
        Button var6 = new Button(this.skin.getDrawable("Clubs_Button"));
        var6.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                MyGame var5 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.game.setScreen(RoomsScreen.this.game.offlineclubs);
                RoomsScreen.this.game.getHandler().LogEventFirebase(RoomsScreen.this.game.CLUBS_CLICK);
            }
        });
        this.Shkaf = new Button(this.skin.getDrawable("Shkaf_Button"));
        this.Shkaf.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                Sound var3 = RoomsScreen.this.soundGarderodOpen;
                MyGame var4 = RoomsScreen.this.game.game;
                var3.play(MyGame.VOLUME);
                RoomsScreen.this.WindowShkaf();
            }
        });
        Table var12 = new Table();
        var12.add(var5).center().height(80.0F).width(80.0F).pad(16.0F);
        var12.add(this.Shkaf).center().height(80.0F).width(80.0F).pad(16.0F);
        var12.add(var9).center().height(80.0F).width(80.0F).pad(16.0F);
        var12.add(this.Friends).center().height(80.0F).width(80.0F).pad(16.0F);
        var12.add(var6).center().width(80.0F).height(80.0F).pad(16.0F);
        var2 = new Table();
        var2.add(var7).height(380.0F).width(230.0F).center();
        var2.add(var3).height(380.0F).width(570.0F).center();
        this.container.add(var2).expand().fill().colspan(3);
        this.container.row().space(10.0F).padBottom(10.0F);
        this.container.add(var12).expand().center().width(525.0F).height(80.0F);
        this.container.add(this.Create).expand().center().width(215.0F).height(80.0F);
        this.purchasesScroll = new Table();
        this.scrollMagaz = new ScrollPane(this.purchasesScroll, this.skin);
        this.scrollMagaz.setScrollingDisabled(true, false);
        this.scrollMagaz.setVariableSizeKnobs(false);
        this.ticket = new Image();
        this.ticket.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(1);
            }
        });
        this.Vipticket = new Image();
        this.Vipticket.addListener(new ClickListener() {

            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(11);
            }
        });
        this.PasswordClassic = new Image();
        this.PasswordClassic.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(22);
            }
        });
        this.RefreshPercent = new Image();
        this.RefreshPercent.addListener(new ClickListener() {

            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(24);
            }
        });
        this.magazinBandageForManiac = new Image();
        this.magazinBandageForManiac.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(23);
            }
        });
        this.hatObichn = new Image();
        this.hatObichn.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(3);
            }
        });
        this.hatPolos = new Image();
        this.hatPolos.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(4);
            }
        });
        this.hatSanta = new Image();
        this.hatSanta.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(5);
            }
        });
        this.hatBaby = new Image();
        this.hatBaby.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(6);
            }
        });
        this.hatAmerican = new Image();
        this.hatAmerican.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(7);
            }
        });
        this.hatCrown = new Image();
        this.hatCrown.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(8);
            }
        });
        this.hatVIPCrown = new Image();
        this.hatVIPCrown.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(10);
            }
        });
        this.LastSpeechPurchase = new Table();
        this.LastSpeechPurchase.setTouchable(Touchable.enabled);
        this.LastSpeechPurchase.setBackground(this.skin.getDrawable("lastSpeech"));
        this.LastSpeechPurchase.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(9);
            }
        });
        this.NormPotion = new Table();
        this.NormPotion.setTouchable(Touchable.enabled);
        this.NormPotion.setBackground(this.skin.getDrawable("normPotin"));
        this.NormPotion.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(12);
            }
        });
        this.VipPotion = new Table();
        this.VipPotion.setTouchable(Touchable.enabled);
        this.VipPotion.setBackground(this.skin.getDrawable("ClassikPotin"));
        this.VipPotion.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(13);
            }
        });
        this.AcessToClassik = new Table();
        this.AcessToClassik.setTouchable(Touchable.enabled);
        this.AcessToClassik.setBackground(this.skin.getDrawable("magazinAcessToClassik"));
        this.AcessToClassik.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.AgreeMagazin(14);
            }
        });
        this.btnChestInfo = new ImageButton(this.skin.getDrawable("questIMini"));
        this.btnChestInfo.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.stage.addActor(new ChestInfo(RoomsScreen.this.skin, RoomsScreen.this.game));
            }
        });
        this.btnVampChestInfo = new ImageButton(this.skin.getDrawable("questIMini"));
        this.btnVampChestInfo.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.stage.addActor(new VampChestInfo(RoomsScreen.this.skin, RoomsScreen.this.game));
            }
        });
        this.btnNingaChestInfo = new ImageButton(this.skin.getDrawable("questIMini"));
        this.btnNingaChestInfo.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.stage.addActor(new NingaChestInfo(RoomsScreen.this.skin, RoomsScreen.this.game));
            }
        });
        this.imgMagazColorNick = new ImageButton(this.skin, "magazinColorNick");
        this.imgMagazColorNick.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(900, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgMagazChangeNick = new ImageButton(this.skin, "magazinChangeNick");
        this.imgMagazChangeNick.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(901, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgCatChest = new ImageButton(this.skin, "1catchest");
        this.imgCatChest.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(888, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgCatChestFive = new ImageButton(this.skin, "5catchest");
        this.imgCatChestFive.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(889, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgCatChestTen = new ImageButton(this.skin, "10catchest");
        this.imgCatChestTen.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(898, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgVampChest = new ImageButton(this.skin, "1vampchest");
        this.imgVampChest.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(902, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgVampChestFive = new ImageButton(this.skin, "5vampchest");
        this.imgVampChestFive.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(903, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgVampChestTen = new ImageButton(this.skin, "10vampchest");
        this.imgVampChestTen.addListener(new ClickListener() {

            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(904, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgNingaChest = new ImageButton(this.skin, "1ningachest");
        this.imgNingaChest.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(905, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgNingaChestFive = new ImageButton(this.skin, "5ningachest");
        this.imgNingaChestFive.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(906, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.imgNingaChestTen = new ImageButton(this.skin, "10ningachest");
        this.imgNingaChestTen.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(907, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        var12 = new Table();
        var12.add(this.btnChestInfo).height(60.0F).width(60.0F).padRight(23.0F).center();
        var12.add(this.imgCatChest).height(60.0F).width(400.0F).right();
        var2 = new Table();
        var2.add(this.btnVampChestInfo).height(60.0F).width(60.0F).padRight(23.0F).center();
        var2.add(this.imgVampChest).height(60.0F).width(400.0F).right();
        var7 = new Table();
        var7.add(this.btnNingaChestInfo).height(60.0F).width(60.0F).padRight(23.0F).center();
        var7.add(this.imgNingaChest).height(60.0F).width(400.0F).right();
        this.gameMaster = new Image(this.skin, "GM");
        this.gameMaster.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(777, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money100 = new ImageButton(this.skin, "100money");
        this.money100.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(100, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money250 = new ImageButton(this.skin, "250money");
        this.money250.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(250, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money400 = new ImageButton(this.skin, "400money");
        this.money400.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(400, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money600 = new ImageButton(this.skin, "600money");
        this.money600.addListener(new ClickListener() {

            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(600, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money1000 = new ImageButton(this.skin, "1000money");
        this.money1000.addListener(new ClickListener() {
            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(1000, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        this.money1350 = new ImageButton(this.skin, "1350money");
        this.money1350.addListener(new ClickListener() {

            public void clicked(InputEvent var1, float var2, float var3) {
                super.clicked(var1, var2, var3);
                RoomsScreen.this.game.getHandler().magazin(1350, MainMenuScreen.Connect_Class, RoomsScreen.this.game, (String)null);
                RoomsScreen.this.DisablePurchase();
            }
        });
        TextButton var13 = new TextButton("х", this.skin, "login");
        var13.setChecked(true);
        var13.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                RoomsScreen.this.NotvisibleNumber = false;
                RoomsScreen.this.magazin.addAction(Actions.sequence(Actions.moveTo(RoomsScreen.this.magazin.getX(), RoomsScreen.this.magazin.getY() + 480.0F, 0.15F)));
                RoomsScreen.this.GreyI.addAction(Actions.sequence(Actions.moveTo(RoomsScreen.this.magazin.getX(), RoomsScreen.this.magazin.getY() + 480.0F, 0.15F)));
            }
        });
        this.purchasesScroll.add(this.ticket).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.Vipticket).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.PasswordClassic).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.magazinBandageForManiac).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.RefreshPercent).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatObichn).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatPolos).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatSanta).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatBaby).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatAmerican).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatCrown).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.hatVIPCrown).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.LastSpeechPurchase).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.NormPotion).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.VipPotion).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.AcessToClassik).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgMagazChangeNick).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgMagazColorNick).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(var12).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgCatChestFive).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgCatChestTen).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(var2).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgVampChestFive).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgVampChestTen).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(var7).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgNingaChestFive).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.imgNingaChestTen).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.gameMaster).height(196.0F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money100).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money250).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money400).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money600).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money1000).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.purchasesScroll.row();
        this.purchasesScroll.add(this.money1350).height(64.725F).width(483.0F).padTop(18.0F).center();
        this.waitMagazin = new Image();
        this.magazin = new Window("", this.skin, "Magazin");
        this.magazin.top();
        this.magazin.setKeepWithinStage(false);
        this.magazin.add(this.waitMagazin).center().width(40.0F).height(40.0F).expand().padLeft(248.0F).padTop(160.0F);
        this.magazin.add(var13).right().width(35.0F).height(35.0F).pad(10.0F).padBottom(25.0F).expand().bottom();
        this.magazin.row();
        this.magazin.add(this.scrollMagaz).width(700.0F).height(295.0F).center().padBottom(36.0F).colspan(2);
        this.magazin.setSize(700.0F, 547.0F);
        this.magazin.setPosition(50.0F, 490.0F);
        MenuCart var8 = this.game.cart;
        this.GreyI = new Image(MenuCart.Grey);
        this.GreyI.setFillParent(true);
        this.GreyI.setColor(0.5F, 0.5F, 0.5F, 0.5F);
        this.GreyI.setPosition(0.0F, 490.0F);
    }

    public static int getPercentWin() {
        return countWin == 0.0 ? 0 : (int)Math.round(countWin / (countWin + countLose) * 100.0);
    }

    private void tryToChangeRoleInParty(boolean var1) {
        byte var2 = 12;
        byte var3;
        byte var4;
        if (var1) {
            if (this.Role == 1 && this.DonBuy > 0) {
                var3 = 6;
            } else {
                var3 = 1;
            }

            var4 = var3;
            if (this.Role == 1) {
                var4 = var3;
                if (this.VampBuy > 0) {
                    var4 = var3;
                    if (this.DonBuy <= 0) {
                        var4 = 11;
                    }
                }
            }

            var3 = var4;
            if (this.Role == 1) {
                var3 = var4;
                if (this.NingaBuy > 0) {
                    var3 = var4;
                    if (this.DonBuy <= 0) {
                        var3 = var4;
                        if (this.VampBuy <= 0) {
                            var3 = 12;
                        }
                    }
                }
            }

            var4 = var3;
            if (this.Role == 6) {
                var4 = var3;
                if (this.VampBuy > 0) {
                    var4 = 11;
                }
            }

            var3 = var4;
            if (this.Role == 6) {
                var3 = var4;
                if (this.NingaBuy > 0) {
                    var3 = var4;
                    if (this.VampBuy <= 0) {
                        var3 = 12;
                    }
                }
            }

            if (this.Role == 11 && this.NingaBuy > 0) {
                var4 = var2;
            } else {
                var4 = var3;
            }
        } else {
            if (this.Role == 1 && this.NingaBuy > 0) {
                var4 = 12;
            } else {
                var4 = 1;
            }

            var3 = var4;
            if (this.Role == 1) {
                var3 = var4;
                if (this.VampBuy > 0) {
                    var3 = var4;
                    if (this.NingaBuy <= 0) {
                        var3 = 11;
                    }
                }
            }

            var4 = var3;
            if (this.Role == 1) {
                var4 = var3;
                if (this.DonBuy > 0) {
                    var4 = var3;
                    if (this.NingaBuy <= 0) {
                        var4 = var3;
                        if (this.VampBuy <= 0) {
                            var4 = 6;
                        }
                    }
                }
            }

            var3 = var4;
            if (this.Role == 12) {
                var3 = var4;
                if (this.VampBuy > 0) {
                    var3 = 11;
                }
            }

            if (this.Role == 12 && this.DonBuy > 0 && this.VampBuy <= 0) {
                var3 = 6;
            }

            var4 = var3;
            if (this.Role == 11) {
                var4 = var3;
                if (this.DonBuy > 0) {
                    var4 = 6;
                }
            }
        }

        JSONObject var5 = new JSONObject();

        try {
            RoomsScreen var6 = this.game.rooms;
            var5.put("name", Name);
            var5.put("role", var4);
            var5.put("partyName", partyName);
            var5.put("skin", this.game.rooms.actualSkins.get(Integer.valueOf(var4)));
        } catch (JSONException var7) {
            ThrowableExtension.printStackTrace(var7);
        }

        MainMenuScreen.Connect_Class.socket.emit("ChangeRoleInParty", new Object[]{var5});
        this.container.setTouchable(Touchable.disabled);
        this.wait.setOrigin(30.0F, 30.0F);
        this.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
    }

    public void AcceptRewardVideo() {
        Gdx.app.postRunnable(new Runnable() {
            public void run() {
                RoomsScreen.this.madButton.setTouchable(Touchable.enabled);
                RoomsScreen.this.madButton.setVisible(true);
            }
        });
    }

    public void AddAllServers(JSONArray var1, boolean var2) throws JSONException {
        if (!var2) {
            this.table.clear();
        }

        for(int var3 = 0; var3 < var1.length(); ++var3) {
            TextButton var8;
            if (Mod == 0 && Integer.valueOf(var1.getJSONObject(var3).get("Mod").toString()) == 0) {
                this.PodhoditRole = false;

                int var4;
                for(var4 = 0; var4 < var1.getJSONObject(var3).getJSONArray("RoleNeed").length(); ++var4) {
                    if (Integer.valueOf(var1.getJSONObject(var3).getJSONArray("RoleNeed").get(var4).toString()) == this.Role) {
                        switch (this.Role) {
                            case 1:
                                this.PodhoditRole = true;
                                break;
                            case 2:
                                this.PodhoditRole = true;
                                break;
                            case 3:
                                if (this.MedBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 4:
                                if (this.SherifBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 5:
                                if (this.ManiacBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 6:
                                if (this.DonBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 7:
                                if (this.PutanaBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 8:
                                if (this.BessmertBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 9:
                                if (this.TwoFaceBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                                break;
                            case 10:
                                if (this.VorBuy > 0) {
                                    this.PodhoditRole = true;
                                }
                        }
                    }
                }

                if (this.PodhoditRole && (var1.getJSONObject(var3).getBoolean("LowRate") && LowRate || !var1.getJSONObject(var3).getBoolean("LowRate") && !LowRate) && (var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) < 30 && MMR < 30 || var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) >= 30 && MMR < 30 && this.Role != 1 && this.Role != 6 || var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) >= 30 && MMR >= 30 || !var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) < 630 && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) >= 30 && MMR < 630 && MMR >= 30 || !var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) < 30 && MMR < 30 || !var1.getJSONObject(var3).getBoolean("Inc") && Integer.valueOf(var1.getJSONObject(var3).get("mmr").toString()) >= 630 && MMR >= 630)) {
                    this.table.row().padTop(10.0F);
                    Table var5 = this.table;
                    StringBuilder var6 = new StringBuilder();
                    var6.append(Integer.valueOf(var1.getJSONObject(var3).get("numberPlayersInRoom").toString()));
                    var6.append("/");
                    var6.append(Integer.valueOf(var1.getJSONObject(var3).get("numberPlayer").toString()));
                    var5.add(new Label(var6.toString(), this.skin, "UiTextWhite")).center().padLeft(23.0F);
                    if (var1.getJSONObject(var3).getBoolean("Inc")) {
                        var8 = new TextButton("", this.skin, "Server");
                    } else {
                        var8 = new TextButton(var1.getJSONObject(var3).get("name").toString(), this.skin, "Server");
                    }

                    int finalVar = var3;
                    var8.addListener(new ClickListener() {
                        public void clicked(InputEvent inputEvent, float float2, float float3) {
                            TableInRoomScreen.getInstance(RoomsScreen.this.game).leaveParty();
                            RoomsScreen.this.container.setTouchable(Touchable.disabled);
                            MainMenuScreen.Connect_Class.socket.emit("JoinServer", new Object[]{RoomsScreen.this.makeJsonToJoin(var1.getJSONObject(finalVar).get("id").toString())});
                            RoomsScreen.this.wait.setOrigin(30.0F, 30.0F);
                            RoomsScreen.this.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                        }
                    });
                    this.table.add(var8).height(50.0F).width(180.0F).padRight(5.0F).left();
                    Image var9 = new Image();
                    var9.addListener(new QGameStyleListn(this));
                    switch (Integer.valueOf(var1.getJSONObject(var3).get("game_style").toString())) {
                        case 0:
                            var9.setDrawable(this.skin.getDrawable("Otkritiu"));
                            break;
                        case 1:
                            var9.setDrawable(this.skin.getDrawable("poluzak"));
                            break;
                        case 2:
                            var9.setDrawable(this.skin.getDrawable("Zakr"));
                    }

                    this.table.add(var9).height(40.0F).width(30.0F).padRight(4.0F).left();
                    var5 = this.table;
                    var6 = new StringBuilder();
                    var6.append(Integer.valueOf(var1.getJSONObject(var3).get("numberMafia").toString()));
                    var6.append("");
                    var5.add(new Label(var6.toString(), this.skin, "UiTextWhite")).right();
                    MyGame var11 = this.game.game;
                    var9 = new Image(MyGame.MafiaI);
                    var9.addListener(new QMafiaListner(this));
                    this.table.add(var9).height(40.0F).width(30.0F).padRight(2.0F);
                    JSONArray var10 = var1.getJSONObject(var3).getJSONArray("RoleNeed");
                    JSONArray var7 = var1.getJSONObject(var3).getJSONArray("RolePlayers");
                    ArrayList var14 = new ArrayList();

                    for(var4 = 0; var4 < var10.length(); ++var4) {
                        if (Integer.valueOf(var10.get(var4).toString()) != 1 && Integer.valueOf(var10.get(var4).toString()) != 2) {
                            var14.add(Integer.valueOf(var10.get(var4).toString()));
                        }
                    }

                    for(var4 = 0; var4 < var7.length(); ++var4) {
                        if (Integer.valueOf(var7.get(var4).toString()) != 1 && Integer.valueOf(var7.get(var4).toString()) != 2) {
                            var14.add(Integer.valueOf(var7.get(var4).toString()));
                        }
                    }

                    MyGame var12;
                    Image var13;
                    if (var14.contains(3)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.MedI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(4)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.SherifI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(5)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.ManiakI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(6)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.DonI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(7)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.PutanaI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(8)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.BessmertI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(9)) {
                        var12 = this.game.game;
                        var13 = new Image(MyGame.TwofaceI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(10)) {
                        var13 = new Image(this.game.game.VorI);
                        this.table.add(var13).height(40.0F).width(30.0F).padRight(2.0F);
                    }

                    if (var14.contains(11)) {
                        var9 = new Image(this.game.game.VampI);
                        this.table.add(var9).height(40.0F).width(30.0F).padRight(2.0F);
                    }
                }

                this.table.left();
            }

            if (Mod == 1 && Integer.valueOf(var1.getJSONObject(var3).get("Mod").toString()) == 1 && this.isClassicAvailible() && (var1.getJSONObject(var3).getBoolean("LowRate") && LowRate || !var1.getJSONObject(var3).getBoolean("LowRate") && !LowRate || !var1.getJSONObject(var3).getBoolean("LowRate") && LowRate && this.countAcessToClassik > 0) && Integer.valueOf(var1.getJSONObject(var3).get("numberPlayersInRoom").toString()) != Integer.valueOf(var1.getJSONObject(var3).get("numberPlayer").toString()) && var1.getJSONObject(var3).getJSONArray("RoleNeed").length() != 0) {
                this.table.row().padTop(10.0F);
                Table var16 = this.table;
                StringBuilder var15 = new StringBuilder();
                var15.append(Integer.valueOf(var1.getJSONObject(var3).get("numberPlayersInRoom").toString()));
                var15.append("/");
                var15.append(Integer.valueOf(var1.getJSONObject(var3).get("numberPlayer").toString()));
                var16.add(new Label(var15.toString(), this.skin, "UiTextWhite")).center().padLeft(23.0F);
                var8 = new TextButton(var1.getJSONObject(var3).get("name").toString(), this.skin, "Server");
                int finalVar1 = var3;
                var8.addListener(new ClickListener() {

                    public void clicked(InputEvent inputEvent, float float2, float float3) {
                        TableInRoomScreen.getInstance(RoomsScreen.this.game).leaveParty();
                        if (var1.getJSONObject(finalVar1).get("pass").toString().equals("выпердыш007")) {
                            if (RoomsScreen.this.arClassicServerToJoin.size() >= 3) {
                                RoomsScreen.this.joinServerERR((JSONArray)null, 23);
                            } else {
                                JSONArray var6 = var1.getJSONObject(finalVar1).getJSONArray("RoleNeed");
                                RoomsScreen.this.Role = Integer.valueOf(var6.get((int)Math.floor(Math.random() * (double)var6.length())).toString());
                                RoomsScreen.this.container.setTouchable(Touchable.disabled);
                                RoomsScreen.this.arClassicServerToJoin.add(var1.getJSONObject(finalVar1).get("id").toString());
                                (new Timer()).scheduleTask(new Timer.Task() {
                                    public void run() {
                                        RoomsScreen.this.arClassicServerToJoin.clear();
                                    }
                                }, 80.0F);
                                JSONObject var7 = new JSONObject();

                                try {
                                    var7.put("room", var1.getJSONObject(finalVar1).get("id"));
                                    var7.put("name", RoomsScreen.Name);
                                    var7.put("role", RoomsScreen.this.Role);
                                    var7.put("mmr", RoomsScreen.this.MMRclassic);
                                    var7.put("money", RoomsScreen.this.XYZ);
                                    var7.put("hat", RoomsScreen.hat);
                                    var7.put("medal", RoomsScreen.medal);
                                    var7.put("VIP", RoomsScreen.VIP);
                                    var7.put("percentWin", RoomsScreen.getPercentWin());
                                    var7.put("like", RoomsScreen.numberLike);
                                    var7.put("dislike", RoomsScreen.numberDisLike);
                                    var7.put("skinRole", RoomsScreen.this.game.rooms.actualSkins.get(RoomsScreen.this.Role));
                                    var7.put("skinShirt", RoomsScreen.this.game.rooms.actualSkins.get(99));
                                    var7.put("maniacWithBandage", false);
                                    if (RoomsScreen.this.VipPotionCount > 0) {
                                        var7.put("potion", true);
                                    } else {
                                        var7.put("potion", false);
                                    }
                                } catch (JSONException var5) {
                                    ThrowableExtension.printStackTrace(var5);
                                }

                                MainMenuScreen.Connect_Class.socket.emit("JoinServer", new Object[]{var7});
                                RoomsScreen.this.wait.setOrigin(30.0F, 30.0F);
                                RoomsScreen.this.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                            }
                        } else {
                            INPasswordClassic var8 = RoomsScreen.this.new INPasswordClassic(RoomsScreen.this, var1, finalVar1);
                            Gdx.input.getTextInput(var8, "Сервер запаролен", "", "Введите пароль от сервера");
                        }

                    }
                });
                this.table.add(var8).height(60.0F).width(200.0F).center();
                this.table.center().top().padRight(50.0F);
            }
        }

    }

    public void AgreeMagazin(int var1) {
        this.agreeMagazin = new Window("", this.skin, "ClubReg");
        this.agreeMagazin.center();
        this.agreeMagazin.setKeepWithinStage(false);
        MenuCart var2 = this.game.cart;
        this.GreyIAgree = new Image(MenuCart.Grey);
        this.GreyIAgree.setFillParent(true);
        this.GreyIAgree.setColor(0.5F, 0.5F, 0.5F, 0.5F);
        Image var3 = new Image();
        TextButton var4 = new TextButton("", this.skin, "DisagreeMagaz");
        var4.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                MyGame var5 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.agreeMagazin.remove();
                RoomsScreen.this.GreyIAgree.remove();
            }
        });
        TextButton var5 = new TextButton("", this.skin, "AgreeMagaz");
        var5.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                RoomsScreen.this.agreeMagazin.setTouchable(Touchable.disabled);
                var3.setDrawable(RoomsScreen.this.skin, "cursor");
                var3.setOrigin(30.0F, 30.0F);
                var3.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                JSONObject var4 = new JSONObject();

                try {
                    var4.put("name", RoomsScreen.Name);
                    var4.put("purchase", var1);
                    var4.put("money", RoomsScreen.this.XYZ);
                } catch (JSONException var3) {
                    ThrowableExtension.printStackTrace(var3);
                }

                MainMenuScreen.Connect_Class.socket.emit("BuyMagazin", new Object[]{var4});
            }
        });
        Label var6;
        Mafia var7;
        Label var8;
        switch (var1) {
            case 1:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_ticket"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 200) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 2:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_see_rang"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 150) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 3:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat1"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 50) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 4:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat2"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 100) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 5:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat3"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 100) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 6:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat4"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 150) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 7:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat5"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 250) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 8:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_hat6"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 500) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 9:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_last_speech"), this.skin, "UiTextWhite");
                var6.setWrap(true);
                var6.setAlignment(1);
                var8 = var6;
                if (this.XYZ < 20) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 10:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_vipCrown"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 10000) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 11:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_vip_ticket"), this.skin, "UiTextWhite");
                var8 = var6;
                if (this.XYZ < 1000) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 12:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_potion"), this.skin, "UiTextWhite");
                var6.setWrap(true);
                var6.setAlignment(1);
                var8 = var6;
                if (this.XYZ < 100) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 13:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_vip_potion"), this.skin, "UiTextWhite");
                var6.setWrap(true);
                var6.setAlignment(1);
                var8 = var6;
                if (this.XYZ < 200) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            case 14:
                var7 = this.game;
                var6 = new Label(Mafia.local.get("magazin_access_classik"), this.skin, "UiTextWhite");
                var6.setWrap(true);
                var6.setAlignment(1);
                var8 = var6;
                if (this.XYZ < 100) {
                    var5.setDisabled(true);
                    var8 = var6;
                }
                break;
            default:
                switch (var1) {
                    case 22:
                        var7 = this.game;
                        var6 = new Label(Mafia.local.get("magazin_lock"), this.skin, "UiTextWhite");
                        var8 = var6;
                        if (this.XYZ < 500) {
                            var5.setDisabled(true);
                            var8 = var6;
                        }
                        break;
                    case 23:
                        var7 = this.game;
                        var6 = new Label(Mafia.local.get("magazin_bandage"), this.skin, "UiTextWhite");
                        var8 = var6;
                        if (this.XYZ < 500) {
                            var5.setDisabled(true);
                            var8 = var6;
                        }
                        break;
                    case 24:
                        var7 = this.game;
                        var6 = new Label(Mafia.local.get("magazin_percent"), this.skin, "UiTextWhite");
                        var8 = var6;
                        if (this.XYZ < 2000) {
                            var5.setDisabled(true);
                            var8 = var6;
                        }
                        break;
                    default:
                        var8 = null;
                }
        }

        var8.setWrap(true);
        var8.setAlignment(1);
        this.agreeMagazin.add(var8).center().expand().width(330.0F).colspan(3);
        this.agreeMagazin.row();
        this.agreeMagazin.add(var4).width(60.0F).height(60.0F).center().bottom();
        this.agreeMagazin.add(var3).width(60.0F).height(60.0F).center();
        this.agreeMagazin.add(var5).width(60.0F).height(60.0F).center().bottom();
        this.agreeMagazin.setSize(380.0F, 170.0F);
        this.agreeMagazin.setPosition(this.stage.getWidth() / 2.0F - this.agreeMagazin.getWidth() / 2.0F, this.stage.getHeight() / 2.0F - this.agreeMagazin.getHeight() / 2.0F);
        this.agreeMagazin.addAction(Actions.sequence(Actions.scaleTo(0.1F, 0.1F), Actions.sequence(Actions.scaleTo(1.0F, 1.0F, 0.2F), Actions.scaleTo(0.95F, 0.95F, 0.1F), Actions.scaleTo(1.0F, 1.0F, 0.1F))));
        this.agreeMagazin.act(1.0F);
        this.stage.addActor(this.GreyIAgree);
        this.stage.addActor(this.agreeMagazin);
    }

    public void DisablePurchase() {
        this.gameMaster.setTouchable(Touchable.disabled);
        this.imgCatChest.setTouchable(Touchable.disabled);
        this.imgCatChestFive.setTouchable(Touchable.disabled);
        this.imgCatChestTen.setTouchable(Touchable.disabled);
        this.imgVampChest.setTouchable(Touchable.disabled);
        this.imgVampChestFive.setTouchable(Touchable.disabled);
        this.imgVampChestTen.setTouchable(Touchable.disabled);
        this.imgNingaChest.setTouchable(Touchable.disabled);
        this.imgNingaChestFive.setTouchable(Touchable.disabled);
        this.imgNingaChestTen.setTouchable(Touchable.disabled);
        this.imgMagazColorNick.setTouchable(Touchable.disabled);
        this.imgMagazChangeNick.setTouchable(Touchable.disabled);
        this.money100.setTouchable(Touchable.disabled);
        this.money250.setTouchable(Touchable.disabled);
        this.money400.setTouchable(Touchable.disabled);
        this.money600.setTouchable(Touchable.disabled);
        this.money1000.setTouchable(Touchable.disabled);
        this.money1350.setTouchable(Touchable.disabled);
    }

    public void FriendsResult(JSONArray var1, Boolean var2) {
        this.FriendWindow.getCell(this.waitFriend).height(1.0F);
        this.FriendWindow.removeActor(this.waitFriend);
        this.FriendWindow.layout();
        Mafia var3 = this.game;
        TextButton var8 = new TextButton(Mafia.local.get("add"), this.skin, "login");
        var8.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                InviteFriendship var8 = RoomsScreen.this.new InviteFriendship(RoomsScreen.this);
                Input var5 = Gdx.input;
                Mafia var3 = RoomsScreen.this.game;
                String var4 = Mafia.local.get("add_friend");
                var3 = RoomsScreen.this.game;
                var5.getTextInput(var8, var4, "", Mafia.local.get("enter_friend_name"));
                MyGame var6 = RoomsScreen.this.game.game;
                Sound var7 = MyGame.buttonSound;
                MyGame var9 = RoomsScreen.this.game.game;
                var7.play(MyGame.VOLUME);
            }
        });
        Mafia var4 = this.game;
        TextButton var5 = new TextButton(Mafia.local.get("delete"), this.skin, "login");
        var5.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var4 = RoomsScreen.this.game.game;
                Sound var5 = MyGame.buttonSound;
                MyGame var6 = RoomsScreen.this.game.game;
                var5.play(MyGame.VOLUME);

                for(int var3 = 0; var3 < RoomsScreen.this.friendTable.getChildren().size; ++var3) {
                    ((Actor)RoomsScreen.this.friendTable.getChildren().get(var3)).setOrigin(70.0F, 25.0F);
                    ((Actor)RoomsScreen.this.friendTable.getChildren().get(var3)).addAction(Actions.forever(Actions.sequence(Actions.scaleTo(0.95F, 0.95F, 0.1F), Actions.scaleTo(1.0F, 1.0F, 0.1F))));
                }

            }
        });
        if (var1 != null) {
            String[] var9 = this.MyFriends.split("\\|");

            for(int var6 = 0; var6 < var9.length; ++var6) {
                TextButton var7;
                if ((Boolean)var1.get(var6)) {
                    var7 = new TextButton(var9[var6], this.skin, "FriendOnline");
                    var7.setTransform(true);
                    int finalVar = var6;
                    var7.addListener(new ClickListener() {

                        public void clicked(InputEvent inputEvent, float float2, float float3) {
                            MyGame var19 = RoomsScreen.this.game.game;
                            Sound var10 = MyGame.buttonSound;
                            MyGame var4 = RoomsScreen.this.game.game;
                            var10.play(MyGame.VOLUME);
                            if (var7.hasActions()) {
                                for(int var5 = 0; var5 < RoomsScreen.this.friendTable.getChildren().size; ++var5) {
                                    ((Actor)RoomsScreen.this.friendTable.getChildren().get(var5)).clearActions();
                                }

                                JSONObject var13 = new JSONObject();

                                try {
                                    var13.put("friend", var7.getText());
                                    var13.put("name", RoomsScreen.Name);
                                } catch (JSONException var8) {
                                    ThrowableExtension.printStackTrace(var8);
                                }

                                MainMenuScreen.Connect_Class.socket.emit("DeleteFriend", new Object[]{var13});
                                var7.remove();
                                RoomsScreen var11 = RoomsScreen.this;
                                String var14 = RoomsScreen.this.MyFriends;
                                StringBuilder var6 = new StringBuilder();
                                var6.append(var7.getText());
                                var6.append("|");
                                var11.MyFriends = var14.replace(var6.toString(), "");
                            } else if (var2) {
                                if (!TableInRoomScreen.getInstance(RoomsScreen.this.game).isFriendAlreadyInParty(var7.getText().toString())) {
                                    JSONObject var12 = new JSONObject();

                                    try {
                                        var12.put("friend", var7.getText().toString());
                                        var12.put("name", RoomsScreen.Name);
                                        var12.put("partyName", RoomsScreen.partyName);
                                        var12.put("role", 1);
                                        var12.put("skin", RoomsScreen.this.game.rooms.actualSkins.get(1));
                                    } catch (JSONException var7) {
                                        ThrowableExtension.printStackTrace(var7);
                                    }

                                    MainMenuScreen.Connect_Class.socket.emit("InviteToParty", new Object[]{var12});
                                    TableInRoomScreen.getInstance(RoomsScreen.this.game).setSendInvite(true);
                                    if (RoomsScreen.this.stage.getActors().contains(RoomsScreen.this.FriendWindow, true)) {
                                        RoomsScreen.this.FriendWindow.remove();
                                        RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                                    }
                                }
                            } else {
                                RoomsScreen.FriendToSend = var9[finalVar];
                                RoomsScreen.this.MessageFromFriend = new FriendMessage(RoomsScreen.FriendToSend, (String)null, RoomsScreen.arMessagesFromFriend, RoomsScreen.this.game, RoomsScreen.this.game.rooms.stage);
                            }

                        }
                    });
                    this.friendTable.row();
                    this.friendTable.add(var7).height(50.0F).width(250.0F).pad(5.0F).center();
                } else {
                    var7 = new TextButton(var9[var6], this.skin, "FriendOffline");
                    var7.setTransform(true);
                    var7.addListener(new ClickListener() {

                        public void clicked(InputEvent var1, float var2, float var3) {
                            MyGame var8 = RoomsScreen.this.game.game;
                            Sound var9 = MyGame.buttonSound;
                            MyGame var4 = RoomsScreen.this.game.game;
                            var9.play(MyGame.VOLUME);
                            if (var7.hasActions()) {
                                for(int var5 = 0; var5 < RoomsScreen.this.friendTable.getChildren().size; ++var5) {
                                    ((Actor)RoomsScreen.this.friendTable.getChildren().get(var5)).clearActions();
                                }

                                JSONObject var11 = new JSONObject();

                                try {
                                    var11.put("friend", var7.getText());
                                    var11.put("name", RoomsScreen.Name);
                                } catch (JSONException var7) {
                                    ThrowableExtension.printStackTrace(var7);
                                }

                                MainMenuScreen.Connect_Class.socket.emit("DeleteFriend", new Object[]{var11});
                                var7.remove();
                                RoomsScreen var6 = RoomsScreen.this;
                                String var10 = RoomsScreen.this.MyFriends;
                                StringBuilder var12 = new StringBuilder();
                                var12.append(var7.getText());
                                var12.append("|");
                                var6.MyFriends = var10.replace(var12.toString(), "");
                            }

                        }
                    });
                    this.friendTable.row();
                    this.friendTable.add(var7).height(50.0F).width(250.0F).pad(5.0F).center();
                }
            }
        }

        this.FriendWindow.row();
        this.FriendWindow.add(this.scrollFriend).height(383.0F).width(280.0F).center().colspan(2).padRight(3.0F).padTop(13.0F);
        this.FriendWindow.row();
        this.FriendWindow.add(var5).width(140.0F).height(50.0F).left().bottom().expand();
        this.FriendWindow.add(var8).width(140.0F).height(50.0F).right().bottom().expand();
        this.GreyI.setTouchable(Touchable.enabled);
        this.FriendWindow.setTouchable(Touchable.enabled);
    }

    public void InviteFriendshipFrom(JSONObject var1, Stage var2) {
        if (this.GreyIinvite != null && this.InviteToFriendship != null && var2.getActors().contains(this.InviteToFriendship, true)) {
            this.InviteToFriendship.remove();
            this.GreyIinvite.remove();
        }

        this.knock.play();
        MenuCart var3 = this.game.cart;
        this.GreyIinvite = new Image(MenuCart.Grey);
        this.GreyIinvite.setFillParent(true);
        this.GreyIinvite.setColor(0.1F, 0.1F, 0.1F, 0.1F);
        this.InviteToFriendship = new Window("", this.skin, "Role");
        StringBuilder var6 = new StringBuilder();
        Mafia var4 = this.game;
        var6.append(Mafia.local.get("player"));
        var6.append(" ");
        var6.append(var1.get("name").toString());
        var6.append(" ");
        var4 = this.game;
        var6.append(Mafia.local.get("want_a_friendship"));
        Label var5 = new Label(var6.toString(), this.skin, "UiTextWhite");
        var5.setWrap(true);
        var5.setAlignment(1);
        TextButton var7 = new TextButton("", this.skin, "DisagreeMagaz");
        var7.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                var3 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.InviteToFriendship.remove();
                RoomsScreen.this.GreyIinvite.remove();
            }
        });
        TextButton var8 = new TextButton("", this.skin, "AgreeMagaz");
        var8.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent changeEvent, Actor var2) {
                JSONObject var4 = new JSONObject();

                try {
                    var4.put("name", RoomsScreen.Name);
                    var4.put("friend", var1.get("name").toString());
                } catch (JSONException var3) {
                    ThrowableExtension.printStackTrace(var3);
                }

                MainMenuScreen.Connect_Class.socket.emit("MakeFriendship", new Object[]{var4});
                MyGame var5 = RoomsScreen.this.game.game;
                Sound var6 = MyGame.buttonSound;
                MyGame var7 = RoomsScreen.this.game.game;
                var6.play(MyGame.VOLUME);
                RoomsScreen.this.InviteToFriendship.remove();
                RoomsScreen.this.GreyIinvite.remove();
                RoomsScreen var9 = RoomsScreen.this;
                StringBuilder var8 = new StringBuilder();
                var8.append(RoomsScreen.this.MyFriends);
                var8.append(var1.get("name").toString());
                var8.append("|");
                var9.MyFriends = var8.toString();
            }
        });
        this.InviteToFriendship.add(var5).width(300.0F).center().expand().colspan(2);
        this.InviteToFriendship.row();
        this.InviteToFriendship.add(var7).width(60.0F).height(60.0F).center().bottom();
        this.InviteToFriendship.add(var8).width(60.0F).height(60.0F).center().bottom();
        this.InviteToFriendship.setSize(380.0F, 170.0F);
        this.InviteToFriendship.setPosition(this.stage.getWidth() / 2.0F - this.InviteToFriendship.getWidth() / 2.0F, this.stage.getHeight() / 2.0F - this.InviteToFriendship.getHeight() / 2.0F);
        this.InviteToFriendship.addAction(Actions.sequence(Actions.scaleTo(0.1F, 0.1F), Actions.sequence(Actions.scaleTo(1.0F, 1.0F, 0.2F), Actions.scaleTo(0.95F, 0.95F, 0.1F), Actions.scaleTo(1.0F, 1.0F, 0.1F))));
        this.InviteToFriendship.act(1.0F);
        var2.addActor(this.GreyIinvite);
        var2.addActor(this.InviteToFriendship);
    }

    public void MessageFromFriend(JSONObject var1, Stage var2) {
        if (this.MessageFromFriend != null && var2.getActors().contains(this.MessageFromFriend, true) && this.MessageFromFriend.getAuthor().equals(var1.get("name").toString()) && this.MessageFromFriend.addNewMessqgeToBigWindow(new Message(var1.get("name").toString(), var1.get("text").toString()))) {
            if (arMessagesFromFriend.containsKey(var1.get("name").toString())) {
                ((ArrayList)arMessagesFromFriend.get(var1.get("name").toString())).add(new Message(var1.get("name").toString(), var1.get("text").toString()));
            } else {
                ArrayList var3 = new ArrayList();
                var3.add(new Message(var1.get("name").toString(), var1.get("text").toString()));
                arMessagesFromFriend.put(var1.get("name").toString(), var3);
            }
        } else {
            this.MessageFromFriend = new FriendMessage(var1.get("name").toString(), var1.get("text").toString(), arMessagesFromFriend, this.game, var2);
        }

    }

    public void OfferToReturn(JSONObject var1) throws InterruptedException {
        this.windowOfferToReturn = new WindowOfferToReturn("", this.skin, var1, this.game);
    }

    public void Reward() {
        Gdx.app.postRunnable(new Runnable() {

            public void run() {
                RoomsScreen var1 = RoomsScreen.this.game.rooms;
                ++var1.XYZ;
                Label var2 = RoomsScreen.this.game.rooms.LabelMoney;
                StringBuilder var3 = new StringBuilder();
                var3.append("");
                var3.append(RoomsScreen.this.game.rooms.XYZ);
                var2.setText(var3.toString());
                Sound var4 = RoomsScreen.this.game.rooms.moneySound;
                MyGame var5 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.game.rooms.PufEffect = new ParticleEffect();
                RoomsScreen.this.game.rooms.PufEffect.load(Gdx.files.internal("particle/Pufff"), Gdx.files.internal(""));
                RoomsScreen.this.game.rooms.PufEffect.setPosition(400.0F, 240.0F);
                RoomsScreen.this.game.rooms.PufEffect.start();
            }
        });
        JSONObject var1 = new JSONObject();

        try {
            var1.put("name", Name);
        } catch (JSONException var3) {
            ThrowableExtension.printStackTrace(var3);
        }

        MainMenuScreen.Connect_Class.socket.emit("Reward", new Object[]{var1});
    }

    public void Servers(JSONArray var1) throws JSONException {
        allServers = var1;
    }

    public void UpdateTask(ArrayList<Integer> var1) {
        Iterator var2 = var1.iterator();
        String var3 = "";
        int var4 = 0;
        int var5 = var4;

        while(var2.hasNext()) {
            int var6 = (Integer)var2.next();
            byte var7 = (byte)var4;
            String var8 = var3;
            int var9 = var5;
            if (this.Task1 != null) {
                if (var6 == this.Task1.getIdTask()) {
                    Task var16 = this.Task1;
                    var4 = this.Task1.getDone();
                    RoomsScreen var19 = this.game.rooms;
                    var8 = var16.setDone(var4 + 1, Name);
                    var9 = var5 + 1;
                    new RewardTask(this.Task1, this.game, var9);
                    if (var8.equals("")) {
                        this.Task1 = null;
                        this.getCountNewTask();
                    }

                    var7 = 1;
                } else {
                    var7 = (byte)var4;
                    var8 = var3;
                    var9 = var5;
                    if (var1.indexOf(var6) == var1.size() - 1) {
                        var8 = this.Task1.setDone(this.Task1.getDone(), (String)null);
                        var9 = var5;
                        var7 = (byte)var4;
                    }
                }
            }

            byte var10 = var7;
            String var11 = var8;
            int var12 = var9;
            RoomsScreen var17;
            StringBuilder var18;
            if (this.Task2 != null) {
                if (var6 == this.Task2.getIdTask()) {
                    Task var22 = this.Task2;
                    var5 = this.Task2.getDone();
                    var17 = this.game.rooms;
                    var3 = var22.setDone(var5 + 1, Name);
                    StringBuilder var23 = new StringBuilder();
                    var23.append(var8);
                    var23.append(var3);
                    var11 = var23.toString();
                    var12 = var9 + 1;
                    new RewardTask(this.Task2, this.game, var12);
                    if (var3.equals("")) {
                        this.Task2 = null;
                        this.getCountNewTask();
                    }

                    var10 = 1;
                } else {
                    var10 = var7;
                    var11 = var8;
                    var12 = var9;
                    if (var1.indexOf(var6) == var1.size() - 1) {
                        var18 = new StringBuilder();
                        var18.append(var8);
                        var18.append(this.Task2.setDone(this.Task2.getDone(), (String)null));
                        var11 = var18.toString();
                        var12 = var9;
                        var10 = var7;
                    }
                }
            }

            var4 = var10;
            var3 = var11;
            var5 = var12;
            if (this.Task3 != null) {
                if (var6 == this.Task3.getIdTask()) {
                    Task var20 = this.Task3;
                    var5 = this.Task3.getDone();
                    var17 = this.game.rooms;
                    var8 = var20.setDone(var5 + 1, Name);
                    var18 = new StringBuilder();
                    var18.append(var11);
                    var18.append(var8);
                    var3 = var18.toString();
                    var5 = var12 + 1;
                    new RewardTask(this.Task3, this.game, var5);
                    if (var8.equals("")) {
                        this.Task3 = null;
                        this.getCountNewTask();
                    }

                    var4 = 1;
                } else {
                    var4 = var10;
                    var3 = var11;
                    var5 = var12;
                    if (var1.indexOf(var6) == var1.size() - 1) {
                        var18 = new StringBuilder();
                        var18.append(var11);
                        var18.append(this.Task3.setDone(this.Task3.getDone(), (String)null));
                        var3 = var18.toString();
                        var4 = var10;
                        var5 = var12;
                    }
                }
            }
        }

        if (var4 != 0) {
            Application var21 = Gdx.app;
            StringBuilder var14 = new StringBuilder();
            var14.append("NewTaskString = ");
            var14.append(var3);
            var21.log("NewTaskString", var14.toString());
            JSONObject var15 = new JSONObject();

            try {
                var15.put("TaskString", var3);
                var15.put("name", Name);
            } catch (JSONException var13) {
                ThrowableExtension.printStackTrace(var13);
            }

            MainMenuScreen.Connect_Class.socket.emit("UpdateTaskString", new Object[]{var15});
        }

    }

    public void UpdateWindow(final int i) {
        final Window window = new Window("", this.skin, "update");
        window.setPosition(235.0f, 100.0f);
        window.setSize(550.0f, 330.0f);
        Label label = new Label("", this.skin, "UiTextYellow");
        if (i == 3) {
            Mafia mafia = this.game;
            label.setText(Mafia.local.get("end_season"));
            window.add(label).center().width(350.0f).height(100.0f).colspan(2).padBottom(20.0f);
            window.row();
            this.moneyBonus = OldMMR / 5;
            Image image = null;
            if (OldMMR < 180) {
                Skin skin = this.game.game.skin;
                this.oldRang = new Image(skin, "Lvl" + (OldMMR / 30));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
            } else {
                this.oldRang = new Image();
            }
            if (OldMMR >= 180 && OldMMR < 380) {
                Skin skin2 = this.game.game.skin;
                this.oldRang = new Image(skin2, "Lvl" + (6 + ((OldMMR - 180) / 40)));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                MyGame myGame = this.game.game;
                image = new Image(MyGame.JunHatGreen);
            }
            if (OldMMR >= 380 && OldMMR < 630) {
                Skin skin3 = this.game.game.skin;
                this.oldRang = new Image(skin3, "Lvl" + (11 + ((OldMMR - 380) / 50)));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                MyGame myGame2 = this.game.game;
                image = new Image(MyGame.JunHatBlue);
            }
            if (OldMMR >= 630 && OldMMR < 1230) {
                Skin skin4 = this.game.game.skin;
                this.oldRang = new Image(skin4, "Lvl" + (16 + ((OldMMR - 630) / 60)));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                if (OldMMR >= 630 && OldMMR < 930) {
                    MyGame myGame3 = this.game.game;
                    image = new Image(MyGame.JunHatRed);
                } else {
                    MyGame myGame4 = this.game.game;
                    image = new Image(MyGame.JunHatGold);
                }
            }
            if (OldMMR >= 1230 && OldMMR < 1830) {
                Skin skin5 = this.game.game.skin;
                this.oldRang = new Image(skin5, "Lvl" + (26 + ((OldMMR - 1230) / 100)));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                MyGame myGame5 = this.game.game;
                image = new Image(MyGame.JunHatPurp);
            }
            if (OldMMR >= 1830 && OldMMR < 3330) {
                Skin skin6 = this.game.game.skin;
                this.oldRang = new Image(skin6, "Lvl" + (31 + ((OldMMR - 1830) / 300)));
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                MyGame myGame6 = this.game.game;
                image = new Image(MyGame.JunHatBlack);
            }
            if (OldMMR >= 3030) {
                this.oldRang = new Image(this.game.game.skin, "Lvl35");
                window.add(this.oldRang).padRight(25.0f).width(60.0f).height(60.0f).center();
                MyGame myGame7 = this.game.game;
                image = new Image(MyGame.JunHatBlack);
            }
            Table table = new Table();
            table.setBackground(this.skin.getDrawable("BUTTON_Green"));
            table.add(new Label("+" + this.moneyBonus, this.skin, "Kursiv3")).center();
            table.add(new Image(this.skin, "money")).center().padLeft(1.0f).width(30.0f).height(30.0f);
            window.add(table).width(120.0f).height(60.0f).center();
            if (image != null) {
                window.row();
                window.add(image).width(80.0f).height(80.0f).colspan(3).center();
            }
            new Timer().scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    Sound sound = RoomsScreen.this.newRang;
                    MyGame myGame8 = RoomsScreen.this.game.game;
                    sound.play(MyGame.VOLUME);
                    RoomsScreen.this.FireEffect = new ParticleEffect();
                    RoomsScreen.this.FireEffect.load(Gdx.files.internal("particle/fire"), Gdx.files.internal(""));
                    RoomsScreen.this.FireEffect.setPosition(400.0f, 230.0f);
                    RoomsScreen.this.FireEffect.start();
                    RoomsScreen.this.oldRang.setDrawable(RoomsScreen.this.rating.getDrawable());
                }
            }, 3.0f);
        }
        label.setAlignment(1);
        label.setWrap(true);
        MenuCart menuCart = this.game.cart;
        final Image image2 = new Image(MenuCart.Grey);
        image2.setFillParent(true);
        image2.setColor(0.5f, 0.5f, 0.5f, 0.5f);
        window.setOrigin(window.getWidth() / 2.0f, window.getHeight() / 2.0f);
        window.addAction(Actions.sequence(Actions.scaleTo(0.1f, 0.1f), Actions.sequence(Actions.scaleTo(1.0f, 1.0f, 0.2f), Actions.scaleTo(0.95f, 0.95f, 0.1f), Actions.scaleTo(1.0f, 1.0f, 0.1f))));
        image2.addListener(new ClickListener() { 
            @Override
            public void clicked(InputEvent inputEvent, float f, float f2) {
                window.remove();
                image2.remove();
                if (i == 3) {
                    RoomsScreen.OldMMR = 0;
                    RoomsScreen.this.XYZ += RoomsScreen.this.moneyBonus;
                    RoomsScreen.this.LabelMoney.setText("" + RoomsScreen.this.XYZ);
                    RoomsScreen.this.moneyBonus = 0;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", RoomsScreen.Name);
                    } catch (JSONException e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    MainMenuScreen.Connect_Class.socket.emit("ResetSeason", jSONObject);
                }
            }
        });
        window.addListener(new ClickListener() { 
            @Override
            public void clicked(InputEvent inputEvent, float f, float f2) {
                window.remove();
                image2.remove();
                if (i == 3) {
                    RoomsScreen.OldMMR = 0;
                    RoomsScreen.this.XYZ += RoomsScreen.this.moneyBonus;
                    RoomsScreen.this.LabelMoney.setText("" + RoomsScreen.this.XYZ);
                    RoomsScreen.this.moneyBonus = 0;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", RoomsScreen.Name);
                    } catch (JSONException e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    MainMenuScreen.Connect_Class.socket.emit("ResetSeason", jSONObject);
                }
            }
        });
        window.act(1.0f);
        this.stage.addActor(image2);
        this.stage.addActor(window);
    }


    public void WindowFriend(boolean var1) {
        this.FriendWindow = new Window("", this.skin, "Friend");
        this.FriendWindow.top();
        this.GreyI.addAction(Actions.moveTo(0.0F, 0.0F));
        this.GreyI.addListener(new ClickListener() {
            public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                if (RoomsScreen.this.stage.getActors().contains(RoomsScreen.this.FriendWindow, true)) {
                    RoomsScreen.this.FriendWindow.remove();
                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                }

                return true;
            }
        });
        this.FriendWindow.row();
        this.FriendWindow.setSize(300.0F, 450.0F);
        this.FriendWindow.setPosition(480.0F, 15.0F);
        this.friendTable = new Table();
        this.friendTable.center();
        this.scrollFriend = new ScrollPane(this.friendTable, this.skin);
        this.scrollFriend.setScrollingDisabled(true, false);
        this.scrollFriend.setVariableSizeKnobs(false);
        String[] var2 = this.MyFriends.split("\\|");
        if (!this.MyFriends.isEmpty()) {
            JSONArray var3 = new JSONArray();
            int var4 = 0;

            while(true) {
                try {
                    if (var4 >= var2.length) {
                        break;
                    }

                    var3.put(var2[var4]);
                } catch (JSONException var5) {
                    ThrowableExtension.printStackTrace(var5);
                    break;
                }

                ++var4;
            }

            MainMenuScreen.Connect_Class.socket.emit("OnlineFriend", new Object[]{var3, var1});
            this.waitFriend = new Image();
            this.waitFriend.setDrawable(this.skin, "cursor");
            this.waitFriend.setOrigin(30.0F, 30.0F);
            this.waitFriend.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
            this.FriendWindow.add(this.waitFriend).width(50.0F).height(50.0F).center().expand();
            this.FriendWindow.setTouchable(Touchable.disabled);
            this.GreyI.setTouchable(Touchable.disabled);
        } else {
            Mafia var8 = this.game;
            TextButton var9 = new TextButton(Mafia.local.get("add"), this.skin, "login");
            var9.addListener(new ChangeListener() {
                public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                    MyGame var5 = RoomsScreen.this.game.game;
                    Sound var6 = MyGame.buttonSound;
                    MyGame var8 = RoomsScreen.this.game.game;
                    var6.play(MyGame.VOLUME);
                    InviteFriendship var9 = RoomsScreen.this.new InviteFriendship(RoomsScreen.this);
                    Input var7 = Gdx.input;
                    Mafia var3 = RoomsScreen.this.game;
                    String var4 = Mafia.local.get("add_friend");
                    var3 = RoomsScreen.this.game;
                    var7.getTextInput(var9, var4, "", Mafia.local.get("enter_friend_name"));
                }
            });
            Mafia var6 = this.game;
            TextButton var7 = new TextButton(Mafia.local.get("delete"), this.skin, "login");
            var7.setDisabled(true);
            var7.addListener(new ChangeListener() {
                public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                }
            });
            this.FriendWindow.add(var7).width(140.0F).height(50.0F).left().bottom().expand();
            this.FriendWindow.add(var9).width(140.0F).height(50.0F).right().bottom().expand();
        }

        this.FriendWindow.setOrigin(0.0F, 0.0F);
        this.FriendWindow.addAction(Actions.sequence(Actions.scaleTo(0.1F, 0.1F), Actions.sequence(Actions.scaleTo(1.0F, 1.0F, 0.2F))));
        this.FriendWindow.act(1.0F);
        this.stage.addActor(this.FriendWindow);
    }

    public void WindowHelp(int var1) {
    }

    public void WindowMagazin() {
        try {
            this.game.getHandler().magazin(0, MainMenuScreen.Connect_Class, this.game, (String)null);
        } catch (IllegalStateException var3) {
        }

        this.NotvisibleNumber = true;
        if (this.MMRclassic == -1) {
            this.ticket.setDrawable(this.skin, "Ticket");
        } else {
            this.ticket.setDrawable(this.skin, "TicketBuy");
        }

        if (this.XYZ >= 200 && this.MMRclassic == -1) {
            this.ticket.setTouchable(Touchable.enabled);
        } else {
            this.ticket.setTouchable(Touchable.disabled);
        }

        if (this.SuperAccessToClassic) {
            this.Vipticket.setDrawable(this.skin, "TicketVIPBuy");
        } else {
            this.Vipticket.setDrawable(this.skin, "TicketVIP");
        }

        if (this.XYZ >= 1000 && !this.SuperAccessToClassic) {
            this.Vipticket.setTouchable(Touchable.enabled);
        } else {
            this.Vipticket.setTouchable(Touchable.disabled);
        }

        this.RefreshPercent.setDrawable(this.skin, "magazinPercentRefresh");
        if (!this.PasswordBuy) {
            this.PasswordClassic.setDrawable(this.skin, "password");
        } else {
            this.PasswordClassic.setDrawable(this.skin, "passwordBuy");
        }

        if (this.XYZ >= 500 && !this.PasswordBuy) {
            this.PasswordClassic.setTouchable(Touchable.enabled);
        } else {
            this.PasswordClassic.setTouchable(Touchable.disabled);
        }

        if (!this.haveBadge) {
            this.magazinBandageForManiac.setDrawable(this.skin, "magazinBandage");
        } else {
            this.magazinBandageForManiac.setDrawable(this.skin, "magazinBandageBuy");
        }

        if (this.XYZ >= 500 && !this.haveBadge) {
            this.magazinBandageForManiac.setTouchable(Touchable.enabled);
        } else {
            this.magazinBandageForManiac.setTouchable(Touchable.disabled);
        }

        if (!this.HatGopnikBuy) {
            this.hatObichn.setDrawable(this.skin, "HatObichnM");
        } else {
            this.hatObichn.setDrawable(this.skin, "HatObichnBuy");
        }

        if (this.XYZ >= 50 && !this.HatGopnikBuy) {
            this.hatObichn.setTouchable(Touchable.enabled);
        } else {
            this.hatObichn.setTouchable(Touchable.disabled);
        }

        if (!this.HatPolosBuy) {
            this.hatPolos.setDrawable(this.skin, "HatPolosM");
        } else {
            this.hatPolos.setDrawable(this.skin, "HatPolosBuy");
        }

        if (this.XYZ >= 100 && !this.HatPolosBuy) {
            this.hatPolos.setTouchable(Touchable.enabled);
        } else {
            this.hatPolos.setTouchable(Touchable.disabled);
        }

        if (!this.HatSantaBuy) {
            this.hatSanta.setDrawable(this.skin, "HatSantaM");
        } else {
            this.hatSanta.setDrawable(this.skin, "HatSantaBuy");
        }

        if (this.XYZ >= 100 && !this.HatSantaBuy) {
            this.hatSanta.setTouchable(Touchable.enabled);
        } else {
            this.hatSanta.setTouchable(Touchable.disabled);
        }

        if (!this.HatBabyBuy) {
            this.hatBaby.setDrawable(this.skin, "HatBabyM");
        } else {
            this.hatBaby.setDrawable(this.skin, "HatBabyBuy");
        }

        if (this.XYZ >= 150 && !this.HatBabyBuy) {
            this.hatBaby.setTouchable(Touchable.enabled);
        } else {
            this.hatBaby.setTouchable(Touchable.disabled);
        }

        if (!this.HatAmericaBuy) {
            this.hatAmerican.setDrawable(this.skin, "HatAmericanM");
        } else {
            this.hatAmerican.setDrawable(this.skin, "HatAmericanBuy");
        }

        if (this.XYZ >= 250 && !this.HatAmericaBuy) {
            this.hatAmerican.setTouchable(Touchable.enabled);
        } else {
            this.hatAmerican.setTouchable(Touchable.disabled);
        }

        if (!this.HatCrownBuy) {
            this.hatCrown.setDrawable(this.skin, "HatCrownM");
        } else {
            this.hatCrown.setDrawable(this.skin, "HatCrownBuy");
        }

        if (this.XYZ >= 500 && !this.HatCrownBuy) {
            this.hatCrown.setTouchable(Touchable.enabled);
        } else {
            this.hatCrown.setTouchable(Touchable.disabled);
        }

        if (!this.HatVIPCrownBuy) {
            this.hatVIPCrown.setDrawable(this.skin, "magazin_Vip_crown");
        } else {
            this.hatVIPCrown.setDrawable(this.skin, "magazin_Vip_crown_BUY");
        }

        if (this.XYZ >= 10000 && !this.HatVIPCrownBuy) {
            this.hatVIPCrown.setTouchable(Touchable.enabled);
        } else {
            this.hatVIPCrown.setTouchable(Touchable.disabled);
        }

        this.LastSpeechPurchase.clearChildren();
        Table var1;
        StringBuilder var2;
        if (this.LastSpeech > 0) {
            var1 = this.LastSpeechPurchase;
            var2 = new StringBuilder();
            var2.append("x");
            var2.append(this.LastSpeech);
            var1.add(new Label(var2.toString(), this.skin, "chatFriend")).expand().left().padLeft(68.0F).padTop(19.0F);
        }

        if (this.LastSpeech < 5 && this.XYZ >= 20) {
            this.LastSpeechPurchase.setTouchable(Touchable.enabled);
        } else {
            this.LastSpeechPurchase.setTouchable(Touchable.disabled);
        }

        this.NormPotion.clearChildren();
        if (this.NormPotionCount > 0) {
            var1 = this.NormPotion;
            var2 = new StringBuilder();
            var2.append("x");
            var2.append(this.NormPotionCount);
            var1.add(new Label(var2.toString(), this.skin, "chatFriend")).expand().left().padLeft(70.0F).padTop(19.0F);
        }

        if (this.NormPotionCount < 5 && this.XYZ >= 100) {
            this.NormPotion.setTouchable(Touchable.enabled);
        } else {
            this.NormPotion.setTouchable(Touchable.disabled);
        }

        this.VipPotion.clearChildren();
        if (this.VipPotionCount > 0) {
            var1 = this.VipPotion;
            var2 = new StringBuilder();
            var2.append("x");
            var2.append(this.VipPotionCount);
            var1.add(new Label(var2.toString(), this.skin, "chatFriend")).expand().left().padLeft(70.0F).padTop(19.0F);
        }

        if (this.VipPotionCount < 5 && this.XYZ >= 200) {
            this.VipPotion.setTouchable(Touchable.enabled);
        } else {
            this.VipPotion.setTouchable(Touchable.disabled);
        }

        this.AcessToClassik.clearChildren();
        if (this.countAcessToClassik > 0) {
            var1 = this.AcessToClassik;
            var2 = new StringBuilder();
            var2.append("x");
            var2.append(this.countAcessToClassik);
            var1.add(new Label(var2.toString(), this.skin, "chatFriend")).expand().left().padLeft(70.0F).padTop(19.0F);
        }

        if (this.countAcessToClassik < 5 && this.XYZ >= 100) {
            this.AcessToClassik.setTouchable(Touchable.enabled);
        } else {
            this.AcessToClassik.setTouchable(Touchable.disabled);
        }

        if (VIP == 2) {
            this.gameMaster.setTouchable(Touchable.disabled);
            this.gameMaster.setDrawable(this.skin, "GM_buy");
        } else {
            this.gameMaster.setDrawable(this.skin, "GM");
            if (MMR >= 60) {
                this.gameMaster.setTouchable(Touchable.enabled);
            } else {
                this.gameMaster.setTouchable(Touchable.disabled);
            }
        }

        this.magazin.addAction(Actions.sequence(Actions.moveTo(this.magazin.getX(), this.magazin.getY() - 480.0F, 0.2F), Actions.moveTo(this.magazin.getX(), this.magazin.getY() - 440.0F, 0.1F), Actions.moveTo(this.magazin.getX(), this.magazin.getY() - 480.0F, 0.1F), Actions.moveTo(this.magazin.getX(), this.magazin.getY() - 460.0F, 0.1F), Actions.moveTo(this.magazin.getX(), this.magazin.getY() - 480.0F, 0.1F)));
        this.GreyI.addAction(Actions.moveTo(0.0F, 0.0F));
    }

    public void WindowRole(int var1, boolean var2) {
        Image var3;
        TextButton var4;
        Mafia var5;
        TextButton var6;
        Label var8;
        TextButton var9;
        label128: {
            this.roleInfo = new Window("", this.skin, "ClubReg");
            this.roleInfo.center();
            this.roleInfo.setKeepWithinStage(false);
            this.GreyI.addAction(Actions.moveTo(0.0F, 0.0F));
            var3 = new Image();
            var4 = new TextButton("х", this.skin, "login");
            var4.addListener(new ChangeListener() {
                public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                    MyGame var3 = RoomsScreen.this.game.game;
                    Sound var4 = MyGame.buttonSound;
                    var3 = RoomsScreen.this.game.game;
                    var4.play(MyGame.VOLUME);
                    RoomsScreen.this.roleInfo.remove();
                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                }
            });
            var5 = this.game;
            var6 = new TextButton(Mafia.local.get("description"), this.skin, "login");
            var6.addListener(new ChangeListener() {
                public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                    MyGame var3 = RoomsScreen.this.game.game;
                    Sound var4 = MyGame.buttonSound;
                    MyGame var5 = RoomsScreen.this.game.game;
                    var4.play(MyGame.VOLUME);
                    if (RoomsScreen.this.Role >= 8) {
                        VoteCart.prof = RoomsScreen.this.Role + 3;
                    } else {
                        VoteCart.prof = RoomsScreen.this.Role;
                    }

                    RoomsScreen.this.game.setScreen(RoomsScreen.this.game.cart);
                }
            });
            int var7 = this.Role;
            var8 = null;
            if (var7 < 10) {
                if (!var2) {
                    var5 = this.game;
                    var9 = new TextButton(Mafia.local.get("buy"), this.skin, "login");
                    var9.addListener(new ChangeListener() {

                        public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                            RoomsScreen.this.roleInfo.setTouchable(Touchable.disabled);
                            var3.setDrawable(RoomsScreen.this.skin, "cursor");
                            var3.setOrigin(30.0F, 30.0F);
                            var3.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                            JSONObject var4 = new JSONObject();

                            try {
                                var4.put("name", RoomsScreen.Name);
                                var4.put("role", RoomsScreen.this.Role);
                                var4.put("money", RoomsScreen.this.XYZ);
                            } catch (JSONException var3) {
                                ThrowableExtension.printStackTrace(var3);
                            }

                            MainMenuScreen.Connect_Class.socket.emit("Buy", new Object[]{var4});
                        }
                    });
                    break label128;
                }
            } else if (!var2) {
                TextButton var10;
                if (this.Role == 10) {
                    var5 = this.game;
                    var10 = new TextButton(Mafia.local.get("to_chest"), this.skin, "login");
                    var10.addListener(new ChangeListener() {
                        public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                            MyGame var3 = RoomsScreen.this.game.game;
                            Sound var4 = MyGame.buttonSound;
                            var3 = RoomsScreen.this.game.game;
                            var4.play(MyGame.VOLUME);
                            RoomsScreen.this.roleInfo.remove();
                            RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                            RoomsScreen.this.WindowMagazin();
                            RoomsScreen.this.scrollMagaz.setScrollPercentY(0.55F);
                        }
                    });
                } else {
                    var10 = null;
                }

                if (this.Role == 11) {
                    var5 = this.game;
                    var10 = new TextButton(Mafia.local.get("to_chest"), this.skin, "login");
                    var10.addListener(new ChangeListener() {

                        public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                            MyGame var3 = RoomsScreen.this.game.game;
                            Sound var4 = MyGame.buttonSound;
                            MyGame var5 = RoomsScreen.this.game.game;
                            var4.play(MyGame.VOLUME);
                            RoomsScreen.this.roleInfo.remove();
                            RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                            RoomsScreen.this.WindowMagazin();
                            RoomsScreen.this.scrollMagaz.setScrollPercentY(0.65F);
                        }
                    });
                }

                var9 = var10;
                if (this.Role == 12) {
                    var5 = this.game;
                    var9 = new TextButton(Mafia.local.get("to_chest"), this.skin, "login");
                    var9.addListener(new ChangeListener() {

                        public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                            MyGame var3 = RoomsScreen.this.game.game;
                            Sound var4 = MyGame.buttonSound;
                            MyGame var5 = RoomsScreen.this.game.game;
                            var4.play(MyGame.VOLUME);
                            RoomsScreen.this.roleInfo.remove();
                            RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                            RoomsScreen.this.WindowMagazin();
                            RoomsScreen.this.scrollMagaz.setScrollPercentY(0.75F);
                        }
                    });
                }
                break label128;
            }

            var9 = null;
        }

        Object var11;
        if (var2) {
            var11 = new RoleSkins(this.game, this.Role, this.skinMafia, this.skinMirn, this.skinDoctor, this.skinSherif, this.skinManiac, this.skinDon, this.skinPutana, this.skinBessmert, this.skinTwoFace, this.skinShirt);
        } else if (var1 != 1) {
            switch (var1) {
                case 3:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_doc"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 60) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 4:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_sher"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 60) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 5:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_man"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 150) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 6:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_don"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 300) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 7:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_putana"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 300) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 8:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_bessmert"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 500) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 9:
                    var5 = this.game;
                    var8 = new Label(Mafia.local.get("price_twoface"), this.skin, "UiTextWhite");
                    var11 = var8;
                    if (this.XYZ < 1000) {
                        var9.setDisabled(true);
                        var11 = var8;
                    }
                    break;
                case 10:
                    var5 = this.game;
                    var11 = new Label(Mafia.local.get("price_vor"), this.skin, "UiTextWhite");
                    var8 = (Label)var11;
                    var8.setWrap(true);
                    var8.setAlignment(16);
                    break;
                case 11:
                    var5 = this.game;
                    var11 = new Label(Mafia.local.get("price_vamp"), this.skin, "UiTextWhite");
                    var8 = (Label)var11;
                    var8.setWrap(true);
                    var8.setAlignment(16);
                    break;
                case 12:
                    var5 = this.game;
                    var11 = new Label(Mafia.local.get("price_ninga"), this.skin, "UiTextWhite");
                    var8 = (Label)var11;
                    var8.setWrap(true);
                    var8.setAlignment(16);
                    break;
                default:
                    var11 = var8;
            }
        } else {
            var5 = this.game;
            var11 = new Label(Mafia.local.get("mafia_not_availible"), this.skin, "UiTextWhite");
            ((Label)var11).setWrap(true);
        }

        Table var12 = new Table();
        if (var1 >= 10) {
            var12.add((Actor)var11).right().width(300.0F);
        } else if (var1 == 1) {
            if (var2) {
                var12.add((Actor)var11).center();
            } else {
                var12.add((Actor)var11).center().width(300.0F);
            }
        } else {
            var12.add((Actor)var11).center();
        }

        if (!var2) {
            if (this.Role < 10) {
                if (this.Role == 1) {
                    var12.add(new Image(this.skin, "Lvl1")).width(50.0F).height(50.0F).padLeft(2.0F);
                } else {
                    var12.add(new Image(this.skin, "money")).width(25.0F).height(25.0F).padLeft(2.0F);
                }
            } else {
                if (this.Role == 10) {
                    var12.add(new Image(this.skin, "catChest")).width(70.0F).height(70.0F).left().padLeft(2.0F);
                }

                if (this.Role == 11) {
                    var12.add(new Image(this.skin, "VampChest")).width(70.0F).height(70.0F).left().padLeft(2.0F);
                }

                if (this.Role == 12) {
                    var12.add(new Image(this.skin, "NingaChest")).width(70.0F).height(70.0F).left().padLeft(2.0F);
                }
            }
        }

        this.roleInfo.add(var4).right().top().width(40.0F).height(40.0F).colspan(3).expand();
        this.roleInfo.row();
        this.roleInfo.add(var12).center().expand().colspan(3);
        this.roleInfo.row();
        if (var2 || !var2 && this.Role == 1) {
            this.roleInfo.add(var6).width(170.0F).height(60.0F).center().bottom().expand();
        } else {
            this.roleInfo.add(var6).width(170.0F).height(60.0F).left().bottom().expand();
            this.roleInfo.add(var3).width(60.0F).height(60.0F).expand().center();
            this.roleInfo.add(var9).width(170.0F).height(60.0F).right().bottom().expand();
        }

        if (var2) {
            label133: {
                if (var11.getClass().equals(RoleSkins.class)) {
                    RoleSkins var13 = (RoleSkins)var11;
                    if (var13.getChildren().size > 3 && var13.getChildren().size <= 6) {
                        this.roleInfo.setSize(600.0F, 250.0F);
                        break label133;
                    }
                }

                if (var11.getClass().equals(RoleSkins.class) && ((RoleSkins)var11).getChildren().size > 6) {
                    this.roleInfo.setSize(800.0F, 250.0F);
                } else {
                    this.roleInfo.setSize(400.0F, 250.0F);
                }
            }
        } else {
            this.roleInfo.setSize(450.0F, 250.0F);
        }

        this.roleInfo.setPosition(this.stage.getWidth() / 2.0F - this.roleInfo.getWidth() / 2.0F, this.stage.getHeight() / 2.0F - this.roleInfo.getHeight() / 2.0F);
        this.roleInfo.addAction(Actions.sequence(Actions.scaleTo(0.1F, 0.1F), Actions.sequence(Actions.scaleTo(1.0F, 1.0F, 0.2F), Actions.scaleTo(0.95F, 0.95F, 0.1F), Actions.scaleTo(1.0F, 1.0F, 0.1F))));
        this.roleInfo.act(1.0F);
        this.stage.addActor(this.roleInfo);
    }

    public void WindowShkaf() {
        medal = 0;
        (new Timer()).scheduleTask(new Timer.Task() {
            public void run() {
                RoomsScreen.this.NotvisibleNumber = true;
            }
        }, 0.1F);
        this.shkaf = new Window("", this.skin, "Garderob");
        this.shkaf.setKeepWithinStage(false);
        this.shkaf.top();
        this.shkaf.padLeft(30.0F);
        this.shkaf.padRight(37.0F);
        this.GreyI.addAction(Actions.moveTo(0.0F, 0.0F));
        TextButton var1 = new TextButton("х", this.skin, "login");
        var1.addListener(new ChangeListener() {

            public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
                MyGame var3 = RoomsScreen.this.game.game;
                Sound var4 = MyGame.buttonSound;
                var3 = RoomsScreen.this.game.game;
                var4.play(MyGame.VOLUME);
                RoomsScreen.this.shkaf.remove();
                RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                RoomsScreen.this.NotvisibleNumber = false;
            }
        });
        this.shkaf.setSize(600.0F, 450.0F);
        this.shkaf.setPosition(this.stage.getWidth() / 2.0F - this.shkaf.getWidth() / 2.0F, this.stage.getHeight() / 2.0F - this.shkaf.getHeight() / 2.0F);
        Table var2 = new Table();
        ScrollPane var3 = new ScrollPane(var2);
        this.shkaf.add(var1).right().top().width(35.0F).height(35.0F).expandX();
        this.shkaf.row();
        Table var10 = new Table();
        StringBuilder var4 = new StringBuilder();
        var4.append(numberLike);
        Mafia var5 = this.game;
        var4.append(Mafia.local.get("like"));
        var10.add(new Label(var4.toString(), this.game.game.skin, "PercentWin")).pad(12.0F).center();
        if (numberDisLike == 0) {
            var4 = new StringBuilder();
            var4.append(numberDisLike);
            var5 = this.game;
            var4.append(Mafia.local.get("dislike"));
            var10.add(new Label(var4.toString(), this.game.game.skin, "Dislike")).pad(12.0F).center();
        }

        Mafia var16;
        StringBuilder var17;
        if (numberDisLike == 1) {
            var17 = new StringBuilder();
            var17.append(numberDisLike);
            var16 = this.game;
            var17.append(Mafia.local.get("dislike"));
            var10.add(new Label(var17.toString(), this.game.game.skin, "Dislike")).pad(12.0F).center();
        }

        if (numberDisLike >= 2) {
            var17 = new StringBuilder();
            var17.append(numberDisLike);
            var16 = this.game;
            var17.append(Mafia.local.get("dislike"));
            var10.add(new Label(var17.toString(), this.game.game.skin, "Dislike")).pad(12.0F).center();
        }

        if (VIP == 2) {
            var17 = new StringBuilder();
            var17.append(numberOfOpinion);
            var16 = this.game;
            var17.append(Mafia.local.get("opinion"));
            var10.add(new Label(var17.toString(), this.game.game.skin, "PercentWin")).padLeft(12.0F);
            var10.row();
            var17 = new StringBuilder();
            var17.append(getPercentWin());
            var16 = this.game;
            var17.append(Mafia.local.get("percent_win"));
            var10.add(new Label(var17.toString(), this.game.game.skin, "PercentWin")).colspan(3).center();
        }

        var2.add(var10).colspan(10);
        var2.row();
        int var6;
        MyGame var11;
        Image var12;
        if (this.HatGopnikBuy) {
            var11 = this.game.game;
            var12 = new Image(MyGame.Hat1);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 1) {
                        RoomsScreen.hat = 1;
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.Hat1));
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
            var6 = 1;
        } else {
            var6 = 0;
        }

        int var7 = var6;
        if (this.HatPolosBuy) {
            var7 = var6 + 1;
            var11 = this.game.game;
            var12 = new Image(MyGame.Hat2);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 2) {
                        RoomsScreen.hat = 2;
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat2));
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        int var8 = var7;
        if (this.HatSantaBuy) {
            var8 = var7 + 1;
            var11 = this.game.game;
            var12 = new Image(MyGame.Hat3);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 3) {
                        RoomsScreen.hat = 3;
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.Hat3));
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var6 = var8;
        if (this.HatBabyBuy) {
            var6 = var8 + 1;
            if (var6 == 4) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat4);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 4) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat4));
                        RoomsScreen.hat = 4;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var7 = var6;
        if (this.HatAmericaBuy) {
            var7 = var6 + 1;
            if (var7 == 4) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat5);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 5) {
                        RoomsScreen.hat = 5;
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.Hat5));
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var6 = var7;
        if (this.HatCrownBuy) {
            var6 = var7 + 1;
            if (var6 == 4) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat6);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 6) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.Hat6));
                        RoomsScreen.hat = 6;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var7 = var6;
        if (this.HatPirateBuy) {
            var7 = var6 + 1;
            if (var7 == 4 || var7 == 7) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat7);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 9) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat7));
                        RoomsScreen.hat = 9;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var8 = var7;
        if (this.HatWitchBuy) {
            var8 = var7 + 1;
            if (var8 == 4 || var8 == 7) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat8);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {

                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 10) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.Hat8));
                        RoomsScreen.hat = 10;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var6 = var8;
        if (this.HatSambreroBuy) {
            var6 = var8 + 1;
            if (var6 == 4 || var6 == 7) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat9);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {

                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 11) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat9));
                        RoomsScreen.hat = 11;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var7 = var6;
        if (this.HatMilitaryBuy) {
            var7 = var6 + 1;
            if (var7 == 4 || var7 == 7 || var7 == 10) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat10);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 12) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat10));
                        RoomsScreen.hat = 12;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var6 = var7;
        if (this.HatBantBuy) {
            var6 = var7 + 1;
            if (var6 == 4 || var6 == 7 || var6 == 10) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat11);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 13) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat11));
                        RoomsScreen.hat = 13;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var8 = var6;
        if (this.HatUshankaBuy) {
            var8 = var6 + 1;
            if (var8 == 4 || var8 == 7 || var8 == 10) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.Hat12);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 14) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.Hat12));
                        RoomsScreen.hat = 14;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var7 = var8;
        if (this.HatJapan1) {
            var7 = var8 + 1;
            if (var7 == 4 || var7 == 7 || var7 == 10 || var7 == 13) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.HatJapan1);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 16) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var4 = RoomsScreen.this.shkafButton;
                        MyGame var5 = RoomsScreen.this.game.game;
                        var4.add(new Image(MyGame.HatJapan1));
                        RoomsScreen.hat = 16;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var6 = var7;
        if (this.HatJapan2) {
            var6 = var7 + 1;
            if (var6 == 4 || var6 == 7 || var6 == 10 || var6 == 13) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.HatJapan2);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 17) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.HatJapan2));
                        RoomsScreen.hat = 17;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        var7 = var6;
        if (this.HatJapan3) {
            var7 = var6 + 1;
            if (var7 == 4 || var7 == 7 || var7 == 10 || var7 == 13) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.HatJapan3);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 18) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.HatJapan3));
                        RoomsScreen.hat = 18;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        if (this.HatVIPCrownBuy) {
            ++var7;
            if (var7 == 4 || var7 == 7 || var7 == 10 || var7 == 13 || var7 == 16) {
                var2.row();
            }

            var11 = this.game.game;
            var12 = new Image(MyGame.HatVIPcrown);
            var2.add(var12).width(60.0F).height(60.0F).center().expand();
            var12.addListener(new ClickListener() {
                public void clicked(InputEvent var1, float var2, float var3) {
                    super.clicked(var1, var2, var3);
                    if (RoomsScreen.hat != 15) {
                        RoomsScreen.this.shkafButton.clearChildren();
                        Stack var5 = RoomsScreen.this.shkafButton;
                        MyGame var4 = RoomsScreen.this.game.game;
                        var5.add(new Image(MyGame.HatVIPcrown));
                        RoomsScreen.hat = 15;
                    } else {
                        RoomsScreen.hat = 0;
                        RoomsScreen.this.shkafButton.clearChildren();
                    }

                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.NotvisibleNumber = false;
                }
            });
        }

        if (this.RangHat != null || VIP == 2 || GeorgLent || isInstaHat) {
            var2.row();
            var10 = new Table();
            MyGame var18;
            Image var19;
            if (GeorgLent) {
                var18 = this.game.game;
                var19 = new Image(MyGame.HatHoliday);
                var10.add(var19).width(60.0F).height(60.0F).center().expand().padLeft(15.0F).padRight(15.0F);
                var19.addListener(new ClickListener() {
                    public void clicked(InputEvent var1, float var2, float var3) {
                        super.clicked(var1, var2, var3);
                        if (RoomsScreen.hat != 8) {
                            RoomsScreen.this.shkafButton.clearChildren();
                            Stack var5 = RoomsScreen.this.shkafButton;
                            MyGame var4 = RoomsScreen.this.game.game;
                            var5.add(new Image(MyGame.HatHoliday));
                            RoomsScreen.hat = 8;
                        } else {
                            RoomsScreen.hat = 0;
                            RoomsScreen.this.shkafButton.clearChildren();
                        }

                        RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                        RoomsScreen.this.shkaf.remove();
                        RoomsScreen.this.NotvisibleNumber = false;
                    }
                });
            }

            if (isInstaHat) {
                var18 = this.game.game;
                var19 = new Image(MyGame.HatInsta);
                var10.add(var19).width(60.0F).height(60.0F).center().expand().padLeft(15.0F).padRight(15.0F);
                var19.addListener(new ClickListener() {
                    public void clicked(InputEvent var1, float var2, float var3) {
                        super.clicked(var1, var2, var3);
                        if (RoomsScreen.hat != 19) {
                            RoomsScreen.this.shkafButton.clearChildren();
                            Stack var5 = RoomsScreen.this.shkafButton;
                            MyGame var4 = RoomsScreen.this.game.game;
                            var5.add(new Image(MyGame.HatInsta));
                            RoomsScreen.hat = 19;
                        } else {
                            RoomsScreen.hat = 0;
                            RoomsScreen.this.shkafButton.clearChildren();
                        }

                        RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                        RoomsScreen.this.shkaf.remove();
                        RoomsScreen.this.NotvisibleNumber = false;
                    }
                });
            }

            if (VIP == 2) {
                var18 = this.game.game;
                var19 = new Image(MyGame.HatGM);
                var10.add(var19).width(60.0F).height(60.0F).center().expand().padLeft(15.0F).padRight(15.0F);
                var19.addListener(new ClickListener() {

                    public void clicked(InputEvent var1, float var2, float var3) {
                        super.clicked(var1, var2, var3);
                        if (RoomsScreen.hat != 7) {
                            RoomsScreen.this.shkafButton.clearChildren();
                            Stack var5 = RoomsScreen.this.shkafButton;
                            MyGame var4 = RoomsScreen.this.game.game;
                            var5.add(new Image(MyGame.HatGM));
                            RoomsScreen.hat = 7;
                        } else {
                            RoomsScreen.hat = 0;
                            RoomsScreen.this.shkafButton.clearChildren();
                        }

                        RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                        RoomsScreen.this.shkaf.remove();
                        RoomsScreen.this.NotvisibleNumber = false;
                    }
                });
            }

            if (this.RangHat != null) {
                var10.add(this.RangHat).width(60.0F).height(60.0F).top().center().expand().padLeft(15.0F).padRight(15.0F);
                this.RangHat.clearListeners();
                this.RangHat.addListener(new ClickListener() {

                    public void clicked(InputEvent var1, float var2, float var3) {
                        super.clicked(var1, var2, var3);
                        if (RoomsScreen.medal != RoomsScreen.JunRangHat) {
                            RoomsScreen.medal = RoomsScreen.JunRangHat;
                            RoomsScreen.this.shkafButton.add(RoomsScreen.this.RangHat);
                        } else {
                            RoomsScreen.medal = 0;
                            RoomsScreen.this.shkafButton.removeActor(RoomsScreen.this.RangHat);
                        }

                        RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                        RoomsScreen.this.shkaf.remove();
                        RoomsScreen.this.NotvisibleNumber = false;
                    }
                });
            }

            var2.add(var10).colspan(10).expand().padBottom(15.0F);
        }

        var10 = new Table();
        Label var20;
        Table var21;
        if (this.visionOfPaint > 0) {
            var21 = new Table();
            var17 = new StringBuilder();
            var17.append("x");
            var17.append(this.visionOfPaint);
            var20 = new Label(var17.toString(), this.skin, "chatFriend");
            var21.add(new Image(this.skin, "glasses")).width(50.0F).height(33.0F);
            var21.add(var20).expand().bottom().right();
            var10.add(var21).center().expand().padLeft(15.0F).padTop(10.0F).padBottom(10.0F);
        }

        if (this.LastSpeech > 0) {
            var21 = new Table();
            var17 = new StringBuilder();
            var17.append("x");
            var17.append(this.LastSpeech);
            var20 = new Label(var17.toString(), this.skin, "chatFriend");
            var21.add(new Image(this.game.game.skin.getDrawable("iconLastSpeech"))).width(33.0F).height(33.0F);
            var21.add(var20).expand().bottom().right();
            var10.add(var21).center().expand().center().expand().padLeft(15.0F).padTop(10.0F).padBottom(10.0F);
        }

        if (this.NormPotionCount > 0) {
            var21 = new Table();
            var17 = new StringBuilder();
            var17.append("x");
            var17.append(this.NormPotionCount);
            var20 = new Label(var17.toString(), this.skin, "chatFriend");
            var21.add(new Image(this.skin, "Potion")).width(33.0F).height(33.0F);
            var21.add(var20).expand().bottom().right();
            var10.add(var21).center().expand().padLeft(15.0F).padTop(10.0F).padBottom(10.0F);
        }

        if (this.VipPotionCount > 0) {
            var21 = new Table();
            var17 = new StringBuilder();
            var17.append("x");
            var17.append(this.VipPotionCount);
            var20 = new Label(var17.toString(), this.skin, "chatFriend");
            var21.add(new Image(this.game.game.skin.getDrawable("VipPotion"))).width(33.0F).height(33.0F);
            var21.add(var20).expand().bottom().right();
            var10.add(var21).center().expand().padLeft(15.0F).padTop(10.0F).padBottom(10.0F);
        }

        var2.row();
        var2.add(var10).colspan(10).center().expand().padTop(10.0F).padBottom(10.0F);
        var2.row();
        Label var22;
        if (this.countChest > 0) {
            var10 = new Table();
            var10.setTouchable(Touchable.enabled);
            var10.setBackground(this.skin.getDrawable("catChest"));
            var4 = new StringBuilder();
            var4.append("x");
            var4.append(this.countChest);
            var22 = new Label(var4.toString(), this.skin, "chatFriend");
            var10.add(var22).expand().bottom().right();
            var2.row();
            var2.add(var10).width(130.0F).height(130.0F).center().expand().colspan(10);
            var2.row();
            Label finalVar2 = var22;
            Table finalVar1 = var10;
            var10.addListener(new InputListener() {

                public boolean touchDown(InputEvent inputEvent, float float2, float float3, int float4, int float5) {
                    RoomsScreen var7 = RoomsScreen.this;
                    --var7.countChest;
                    Label var6 = finalVar2;
                    StringBuilder var8 = new StringBuilder();
                    var8.append("x");
                    var8.append(RoomsScreen.this.countChest);
                    var6.setText(var8.toString());
                    if (RoomsScreen.this.countChest <= 0) {
                        finalVar1.remove();
                    }

                    RoomsScreen.this.screenOpenChest = new OpenCatChest(RoomsScreen.this.skin, RoomsScreen.this.game);
                    RoomsScreen.this.stage.addActor(RoomsScreen.this.screenOpenChest);
                    return false;
                }
            });
        }

        if (this.countVampChest > 0) {
            var10 = new Table();
            var10.setTouchable(Touchable.enabled);
            var10.setBackground(this.skin.getDrawable("VampChest"));
            var4 = new StringBuilder();
            var4.append("x");
            var4.append(this.countVampChest);
            var22 = new Label(var4.toString(), this.skin, "chatFriend");
            var10.add(var22).expand().bottom().right();
            var2.row();
            var2.add(var10).width(130.0F).height(130.0F).center().expand().colspan(10);
            var2.row();
            Label finalVar21 = var22;
            Table finalVar11 = var10;
            var10.addListener(new InputListener() {
                public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                    RoomsScreen var7 = RoomsScreen.this;
                    --var7.countVampChest;
                    Label var6 = finalVar21;
                    StringBuilder var8 = new StringBuilder();
                    var8.append("x");
                    var8.append(RoomsScreen.this.countVampChest);
                    var6.setText(var8.toString());
                    if (RoomsScreen.this.countVampChest <= 0) {
                        finalVar11.remove();
                    }

                    RoomsScreen.this.screenOpenChest = new OpenVampChest(RoomsScreen.this.skin, RoomsScreen.this.game);
                    RoomsScreen.this.stage.addActor(RoomsScreen.this.screenOpenChest);
                    return false;
                }
            });
        }

        if (this.countNingaChest > 0) {
            var10 = new Table();
            var10.setTouchable(Touchable.enabled);
            var10.setBackground(this.skin.getDrawable("NingaChest"));
            var4 = new StringBuilder();
            var4.append("x");
            var4.append(this.countNingaChest);
            var22 = new Label(var4.toString(), this.skin, "chatFriend");
            var10.add(var22).expand().bottom().right();
            var2.row();
            var2.add(var10).width(130.0F).height(130.0F).center().expand().colspan(10);
            var2.row();
            Label finalVar22 = var22;
            Table finalVar12 = var10;
            var10.addListener(new InputListener() {

                public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                    RoomsScreen var7 = RoomsScreen.this;
                    --var7.countNingaChest;
                    Label var6 = finalVar22;
                    StringBuilder var8 = new StringBuilder();
                    var8.append("x");
                    var8.append(RoomsScreen.this.countNingaChest);
                    var6.setText(var8.toString());
                    if (RoomsScreen.this.countNingaChest <= 0) {
                        finalVar12.remove();
                    }

                    RoomsScreen.this.screenOpenChest = new OpenNingaChest(RoomsScreen.this.skin, RoomsScreen.this.game);
                    RoomsScreen.this.stage.addActor(RoomsScreen.this.screenOpenChest);
                    return false;
                }
            });
        }

        if (this.ChangeNick) {
            var12 = new Image();
            var12.setDrawable(this.skin.getDrawable("changeNickIcon"));
            var2.row();
            var2.add(var12).width(60.0F).height(60.0F).center().expand().colspan(10);
            var2.row();
            Image finalVar13 = var12;
            var12.addListener(new InputListener() {

                public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                    RoomsScreen.this.wndChangeNick = new WindowChangeNick("", RoomsScreen.this.skin, RoomsScreen.this.game, finalVar13);
                    RoomsScreen.this.stage.addActor(RoomsScreen.this.wndChangeNick);
                    return false;
                }
            });
        }

        if (this.ColorNick) {
            var12 = new Image();
            var12.setDrawable(this.skin.getDrawable("colorNickIcon"));
            var2.row();
            var2.add(var12).width(60.0F).height(60.0F).center().expand().colspan(10);
            var2.row();
            Image finalVar14 = var12;
            var12.addListener(new InputListener() {
                public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                    RoomsScreen.this.wndColorNick = new WindowColorNick("", RoomsScreen.this.skin, RoomsScreen.this.game, finalVar14);
                    RoomsScreen.this.stage.addActor(RoomsScreen.this.wndColorNick);
                    return false;
                }
            });
        }

        var10 = new Table();
        if (this.Task1 != null) {
            var10.row();
            var10.add(new TakInShkaf(this.Task1, this.game)).width(320.0F).height(200.0F);
        }

        if (this.Task2 != null) {
            var10.row();
            var10.add(new TakInShkaf(this.Task2, this.game)).width(320.0F).height(200.0F);
        }

        if (this.Task3 != null) {
            var10.row();
            var10.add(new TakInShkaf(this.Task3, this.game)).width(320.0F).height(200.0F);
        }

        var2.row();
        var2.add(var10).colspan(10).center();
        this.shkaf.add(var3).colspan(2).height(355.0F).width(430.0F);
        Mafia var13 = this.game;
        TextButton var14 = new TextButton(Mafia.local.get("change_password"), this.skin, "login");
        var14.addListener(new InputListener() {
            public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                RoomsScreen.this.wndChangePassword = new WindowChangePassword("", RoomsScreen.this.skin, RoomsScreen.this.game);
                RoomsScreen.this.stage.addActor(RoomsScreen.this.wndChangePassword);
                return false;
            }
        });
        var2.row();
        var2.add(var14).colspan(10).center().width(230.0F).height(55.0F);
        if (!this.mail.equals("")) {
            Label var15;
            try {
                if (this.mail.indexOf(64) != -1) {
                    StringBuilder var23 = new StringBuilder();
                    var23.append(this.mail.substring(0, 2));
                    var23.append("*****");
                    var23.append(this.mail.substring(this.mail.indexOf(64)));
                    var15 = new Label(var23.toString(), this.game.game.skin, "chat");
                } else {
                    var15 = new Label("", this.game.game.skin, "chat");
                }
            } catch (Exception var9) {
                var15 = new Label("", this.game.game.skin, "chat");
            }

            var15.setAlignment(1);
            var2.row();
            var2.add(var15).colspan(10).center().width(230.0F).height(55.0F).pad(5.0F);
            var13 = this.game;
            var14 = new TextButton(Mafia.local.get("change_mail"), this.skin, "login");
            var14.addListener(new InputListener() {
                public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                    RoomsScreen.this.stage.addActor(new WindowCheckMail("", RoomsScreen.this.skin, RoomsScreen.this.game));
                    RoomsScreen.this.shkaf.remove();
                    RoomsScreen.this.GreyI.addAction(Actions.moveTo(0.0F, 480.0F));
                    RoomsScreen.this.NotvisibleNumber = false;
                    return false;
                }
            });
            var2.row();
            var2.add(var14).colspan(10).center().width(230.0F).height(55.0F).pad(7.0F);
        }

        this.shkaf.setOrigin(0.0F, 0.0F);
        this.shkaf.addAction(Actions.sequence(Actions.scaleTo(0.1F, 0.1F), Actions.sequence(Actions.scaleTo(1.0F, 1.0F, 0.2F), Actions.scaleTo(0.95F, 0.95F, 0.1F), Actions.scaleTo(1.0F, 1.0F, 0.1F))));
        this.shkaf.act(1.0F);
        this.stage.addActor(this.shkaf);
    }

    public void WindowWinLose(int var1, String var2, boolean var3) {
        Image var6;
        byte var7;
        label144: {
            Sound var4 = this.WinLose;
            MyGame var5 = this.game.game;
            var4.play(MyGame.VOLUME);
            this.NotvisibleNumber = false;
            (new Timer()).scheduleTask(new Timer.Task() {

                public void run() {
                    RoomsScreen.this.NotvisibleNumber = true;
                }
            }, 1.2F);
            MyGame var12 = this.game.game;
            MyGame.restart = false;
            MenuCart var13 = this.game.cart;
            var6 = new Image(MenuCart.Grey);
            var6.setFillParent(true);
            var6.setColor(0.5F, 0.5F, 0.5F, 0.5F);
            this.window = new Window("", this.skin);
            this.window.setKeepWithinStage(false);
            this.mmr_bar.setAnimateDuration(2.0F);
            switch (var2) {
                case "MirnieWin":
                    var7 = 2;
                    break label144;
                case "ManiacLose":
                    var7 = 4;
                    break label144;
                case "MafiaLose":
                    var7 = 0;
                    break label144;
                case "MafiaWin":
                    var7 = 1;
                    break label144;
                case "MirnieLose":
                    var7 = 3;
                    break label144;
                case "ManiacWin":
                    var7 = 5;
                    break label144;
            }

            var7 = -1;
        }

        Mafia var8;
        Sound var9;
        ArrayList var14;
        StringBuilder var15;
        Mafia var16;
        Object var17;
        StringBuilder var18;
        TextButton var19;
        Mafia var20;
        Table var22;
        MyGame var23;
        StringBuilder var26;
        switch (var7) {
            case 0:
                ++countLose;
                if (Mod == 0) {
                    var22 = new Table();
                    if (this.NormPotionCount <= 0) {
                        var22.setBackground(this.skin.getDrawable("Button"));
                        var26 = new StringBuilder();
                        var26.append(var1);
                        var26.append(" ");
                        var20 = this.game;
                        var26.append(Mafia.local.get("rating"));
                        var22.add(new Label(var26.toString(), this.skin, "Kursiv2")).center();
                    } else {
                        var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                        var20 = this.game;
                        var22.add(new Label(Mafia.local.get("potion"), this.skin, "Kursiv2")).center();
                    }
                } else {
                    var22 = new Table();
                    if (this.VipPotionCount > 0 && this.MMRclassic != 0) {
                        var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                        var20 = this.game;
                        var22.add(new Label(Mafia.local.get("potion"), this.skin, "Kursiv2")).center();
                    } else {
                        var22.setBackground(this.skin.getDrawable("Button"));
                        var22.add(new Label("-", this.skin, "Kursiv2")).center();
                        var22.add(new Image(this.skin, "Zvezda")).center().padLeft(1.0F).width(30.0F).height(40.0F);
                    }
                }

                var17 = var22;
                var18 = new StringBuilder();
                var18.append("+");
                var18.append(VIP * 1);
                var18.append(" ");
                var8 = this.game;
                var18.append(Mafia.local.get("coin"));
                var19 = new TextButton(var18.toString(), this.skin, "Green");
                var9 = this.MafiaLoseSound;
                var23 = this.game.game;
                var9.play(MyGame.VOLUME);
                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/MafiaLoose.png")))));
                break;
            case 1:
                if (this.Role == 1) {
                    var14 = new ArrayList();
                    var14.add(1);
                    if (hat != 0 && medal != 0) {
                        var14.add(11);
                    }

                    if (Setting.numberPlayer == 8) {
                        var14.add(13);
                    }

                    this.UpdateTask(var14);
                }

                ++countWin;
                if (Mod == 0) {
                    var22 = new Table();
                    var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                    var26 = new StringBuilder();
                    var26.append("+");
                    var26.append(var1);
                    var26.append(" ");
                    var20 = this.game;
                    var26.append(Mafia.local.get("rating"));
                    var22.add(new Label(var26.toString(), this.skin, "Kursiv3")).center();
                } else {
                    var22 = new Table();
                    var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                    var22.add(new Label("+", this.skin, "Kursiv3")).center();
                    var22.add(new Image(this.skin, "Zvezda")).center().padLeft(2.0F).width(30.0F).height(40.0F);
                }

                var17 = var22;
                if (var3) {
                    var18 = new StringBuilder();
                    var18.append("+");
                    var18.append(5 * VIP);
                    var18.append(" ");
                    var8 = this.game;
                    var18.append(Mafia.local.get("coin"));
                    var19 = new TextButton(var18.toString(), this.skin, "Green");
                } else {
                    var18 = new StringBuilder();
                    var18.append("+");
                    var18.append(3 * VIP);
                    var18.append(" ");
                    var8 = this.game;
                    var18.append(Mafia.local.get("coin"));
                    var19 = new TextButton(var18.toString(), this.skin, "Green");
                }

                var9 = this.MafiaWinSound;
                var23 = this.game.game;
                var9.play(MyGame.VOLUME);
                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/MafiaWin.png")))));
                break;
            case 2:
                if (this.Role == 2) {
                    var14 = new ArrayList();
                    var14.add(2);
                    this.UpdateTask(var14);
                }

                ++countWin;
                (new Timer()).scheduleTask(new Timer.Task() {
                    public void run() {
                        Sound var1 = RoomsScreen.this.MirnieWinSound;
                        MyGame var2 = RoomsScreen.this.game.game;
                        var1.play(MyGame.VOLUME);
                    }
                }, 1.3F);
                if (Mod == 0) {
                    var22 = new Table();
                    var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                    var15 = new StringBuilder();
                    var15.append("+");
                    var15.append(var1);
                    var15.append(" ");
                    var8 = this.game;
                    var15.append(Mafia.local.get("rating"));
                    var22.add(new Label(var15.toString(), this.skin, "Kursiv3")).center();
                } else {
                    var22 = new Table();
                    var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                    var22.add(new Label("+", this.skin, "Kursiv3")).center();
                    var22.add(new Image(this.skin, "Zvezda")).center().padLeft(2.0F).width(30.0F).height(40.0F);
                }

                var17 = var22;
                if (var3) {
                    var26 = new StringBuilder();
                    var26.append("+");
                    var26.append(5 * VIP);
                    var26.append(" ");
                    var16 = this.game;
                    var26.append(Mafia.local.get("coin"));
                    var19 = new TextButton(var26.toString(), this.skin, "Green");
                } else {
                    var26 = new StringBuilder();
                    var26.append("+");
                    var26.append(3 * VIP);
                    var26.append(" ");
                    var16 = this.game;
                    var26.append(Mafia.local.get("coin"));
                    var19 = new TextButton(var26.toString(), this.skin, "Green");
                }

                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/MirnieWin.png")))));
                break;
            case 3:
                ++countLose;
                if (Mod == 0) {
                    var22 = new Table();
                    if (this.NormPotionCount <= 0) {
                        var22.setBackground(this.skin.getDrawable("Button"));
                        var26 = new StringBuilder();
                        var26.append(var1);
                        var26.append(" ");
                        var20 = this.game;
                        var26.append(Mafia.local.get("rating"));
                        var22.add(new Label(var26.toString(), this.skin, "Kursiv2")).center();
                    } else {
                        var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                        var20 = this.game;
                        var22.add(new Label(Mafia.local.get("potion"), this.skin, "Kursiv2")).center();
                    }
                } else {
                    var22 = new Table();
                    if (this.VipPotionCount > 0 && this.MMRclassic != 0) {
                        var22.setBackground(this.skin.getDrawable("BUTTON_Green"));
                        var20 = this.game;
                        var22.add(new Label(Mafia.local.get("potion"), this.skin, "Kursiv2")).center();
                    } else {
                        var22.setBackground(this.skin.getDrawable("Button"));
                        var22.add(new Label("-", this.skin, "Kursiv2")).center();
                        var22.add(new Image(this.skin, "Zvezda")).center().padLeft(1.0F).width(30.0F).height(40.0F);
                    }
                }

                var17 = var22;
                var26 = new StringBuilder();
                var26.append("+");
                var26.append(VIP * 1);
                var26.append(" ");
                var16 = this.game;
                var26.append(Mafia.local.get("coin"));
                var19 = new TextButton(var26.toString(), this.skin, "Green");
                var9 = this.MirnieLoseSound;
                var23 = this.game.game;
                var9.play(MyGame.VOLUME);
                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/MirnieLose.png")))));
                break;
            case 4:
                ++countLose;
                if (this.NormPotionCount <= 0) {
                    var18 = new StringBuilder();
                    var18.append(var1);
                    var18.append(" ");
                    var20 = this.game;
                    var18.append(Mafia.local.get("rating"));
                    var19 = new TextButton(var18.toString(), this.skin, "Server");
                } else {
                    var16 = this.game;
                    var19 = new TextButton(Mafia.local.get("potion"), this.skin, "Green");
                }

                var15 = new StringBuilder();
                var15.append("+");
                var15.append(VIP * 1);
                var15.append(" ");
                var8 = this.game;
                var15.append(Mafia.local.get("coin"));
                TextButton var24 = new TextButton(var15.toString(), this.skin, "Green");
                Sound var21 = this.ManiacLoseSound;
                MyGame var25 = this.game.game;
                var21.play(MyGame.VOLUME);
                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/ManiacLose.png")))));
                var17 = var19;
                var19 = var24;
                break;
            case 5:
                if (this.Role == 5 && Setting.numberPlayer == 10) {
                    var14 = new ArrayList();
                    var14.add(5);
                    this.UpdateTask(var14);
                }

                ++countWin;
                var15 = new StringBuilder();
                var15.append("+");
                var15.append(var1);
                var15.append(" ");
                var16 = this.game;
                var15.append(Mafia.local.get("rating"));
                var17 = new TextButton(var15.toString(), this.skin, "Green");
                var18 = new StringBuilder();
                var18.append("+");
                var18.append(10 * VIP);
                var18.append(" ");
                var8 = this.game;
                var18.append(Mafia.local.get("coin"));
                var19 = new TextButton(var18.toString(), this.skin, "Green");
                this.mmr_bar.setAnimateDuration(3.0F);
                var9 = this.ManiacWinSound;
                var23 = this.game.game;
                var9.play(MyGame.VOLUME);
                this.window.setStyle(new Window.WindowStyle(this.game.font, Color.BLACK, new TextureRegionDrawable(new TextureRegion(new Texture("local_assets/ManiacWin.png")))));
                break;
            default:
                var19 = null;
                var17 = null;
        }

        this.window.bottom();
        this.madButton = new Table();
        this.madButton.setTransform(true);
        this.madButton.setTouchable(Touchable.enabled);
        this.madButton.setBackground(this.skin.getDrawable("BUTTON_Green"));
        var8 = this.game;
        Label var31 = new Label(Mafia.local.get("watch"), this.skin, "Kursiv3");
        var31.setAlignment(1);
        Mafia var27 = this.game;
        Label var28 = new Label(Mafia.local.get("advertising"), this.skin, "Kursiv3");
        var28.setAlignment(16);
        this.madButton.add(var31).center().width(180.0F).colspan(2);
        this.madButton.row();
        this.madButton.add(var28).right().width(140.0F);
        this.madButton.add(new Image(this.skin, "money")).left().padLeft(2.0F).expandX().width(25.0F).height(25.0F);
        this.madButton.setOrigin(90.0F, 30.0F);
        this.madButton.addAction(Actions.forever(Actions.sequence(Actions.scaleTo(1.2F, 1.2F, 1.0F), Actions.scaleTo(1.0F, 1.0F, 1.0F))));
        this.madButton.addListener(new ClickListener() {
            public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
                Application var6 = Gdx.app;
                StringBuilder var7 = new StringBuilder();
                var7.append("event = ");
                var7.append(var1);
                var7.append("    button = ");
                var7.append(var5);
                var6.log("RewardClick", var7.toString());
                RoomsScreen.this.game.getHandler().mad(RoomsScreen.this.game);
                RoomsScreen.this.madButton.setTouchable(Touchable.disabled);
                RoomsScreen.this.madButton.setVisible(false);
                return true;
            }
        });
        this.madButton.setTouchable(Touchable.disabled);
        this.madButton.setVisible(false);
        Table var32 = new Table();
        TextButton var29 = new TextButton("", this.skin);
        var29.setVisible(false);
        var32.setTouchable(Touchable.enabled);
        var32.add(var29).expand().fill().width(650.0F).height(300.0F).colspan(4);
        int var10 = Setting.KoefMMR;
        var7 = 2;
        if (var10 == 2 && this.Role == 2 && var2.equals("MirnieWin") && Mod == 0) {
            var32.row();
            if (!var3) {
                var7 = 1;
            }

            StringBuilder var30 = new StringBuilder();
            var30.append("+");
            var30.append(var7);
            var32.add(new Label(var30.toString(), this.game.game.skin, "UiTextWhite")).left().padLeft(70.0F).width(30.0F);
            var32.add(new Image(this.game.game.skin, "glasses")).width(50.0F).height(33.0F).left().expand();
            var30 = new StringBuilder();
            var30.append("+");
            var30.append(VIP * var7);
            var32.add(new Label(var30.toString(), this.game.game.skin, "UiTextWhite")).right().width(30.0F).expand();
            var32.add(new Image(this.game.game.skin, "money")).width(30.0F).height(30.0F).right().bottom().padRight(75.0F);
            this.XYZ += VIP * var7;
            this.visionOfPaint += var7;
        }

        this.window.add(var32).colspan(3).expand();
        this.window.row();
        this.window.add((Actor)var17).width(150.0F).height(50.0F).left().expandX();
        this.window.add(this.madButton).width(180.0F).height(60.0F).center().expandX().padBottom(10.0F);
        this.window.add(var19).width(150.0F).height(50.0F).right().expandX();
        this.window.setSize(670.0F, 402.0F);
        this.window.setPosition(this.stage.getWidth() / 2.0F, this.stage.getHeight());
        this.stage.addActor(var6);
        this.stage.addActor(this.window);
        this.window.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.scaleTo(0.1F, 0.1F), Actions.parallel(Actions.fadeIn(1.5F, Interpolation.pow2), Actions.scaleTo(1.0F, 1.0F, 2.0F, Interpolation.pow5), Actions.moveTo(65.0F, 39.0F, 1.5F, Interpolation.swing))));
        ClickListener var11 = new ClickListener() {

            public boolean touchDown(InputEvent inputEvent, float float2, float float3, int int4, int int5) {
                Application var26 = Gdx.app;
                StringBuilder var7 = new StringBuilder();
                var7.append("event = ");
                var7.append(inputEvent);
                var7.append("    button = ");
                var7.append(int5);
                var26.log("WindowClick", var7.toString());
                int4 = RoomsScreen.MMR;
                RoomsScreen.this.NotvisibleNumber = false;
                RoomsScreen var8;
                Label var9;
                MyGame var10;
                Sound var14;
                if (var1 == 0) {
                    var8 = RoomsScreen.this;
                    var8.XYZ += RoomsScreen.VIP * 1;
                    var9 = RoomsScreen.this.LabelMoney;
                    var7 = new StringBuilder();
                    var7.append("");
                    var7.append(RoomsScreen.this.XYZ);
                    var9.setText(var7.toString());
                    if (RoomsScreen.Mod == 1 && RoomsScreen.this.VipPotionCount == 0) {
                        RoomsScreen.this.SmokEffect = new ParticleEffect();
                        RoomsScreen.this.SmokEffect.load(Gdx.files.internal("particle/smoke"), Gdx.files.internal(""));
                        RoomsScreen.this.SmokEffect.setPosition(115.0F, 275.0F);
                        RoomsScreen.this.SmokEffect.start();
                        var14 = RoomsScreen.this.lastRang;
                        var10 = RoomsScreen.this.game.game;
                        var14.play(MyGame.VOLUME);
                        if (RoomsScreen.this.MMRclassic > 0) {
                            var8 = RoomsScreen.this;
                            --var8.MMRclassic;
                        }
                    }

                    if (RoomsScreen.Mod == 1 && RoomsScreen.this.VipPotionCount != 0) {
                        var8 = RoomsScreen.this;
                        --var8.VipPotionCount;
                    }
                }

                StringBuilder var11;
                Sound var13;
                MyGame var16;
                if (var1 < 0) {
                    var8 = RoomsScreen.this;
                    var8.XYZ += RoomsScreen.VIP * 1;
                    var9 = RoomsScreen.this.LabelMoney;
                    var7 = new StringBuilder();
                    var7.append("");
                    var7.append(RoomsScreen.this.XYZ);
                    var9.setText(var7.toString());
                    if (RoomsScreen.Mod == 0) {
                        if (RoomsScreen.this.NormPotionCount <= 0) {
                            if (RoomsScreen.MMR + var1 <= 5230) {
                                var14 = RoomsScreen.this.RegressSound;
                                var10 = RoomsScreen.this.game.game;
                                var14.play(MyGame.VOLUME);
                                RoomsScreen.this.curentProgress = RoomsScreen.this.mmr_bar.getValue();
                                RoomsScreen.this.progressBarStatus = 1;
                                if (RoomsScreen.this.mmr_bar.getValue() + (float)var1 >= 0.0F) {
                                    RoomsScreen.this.mmr_bar.setAnimateDuration((float)(-var1) / 3.9F);
                                    RoomsScreen.this.mmr_bar.setValue(RoomsScreen.this.mmr_bar.getValue() + (float)var1);
                                    Application var15 = Gdx.app;
                                    var11 = new StringBuilder();
                                    var11.append("");
                                    var11.append(var1);
                                    var15.log("Regress", var11.toString());
                                } else {
                                    RoomsScreen.this.mmr_bar.setAnimateDuration(RoomsScreen.this.mmr_bar.getValue() / 3.9F);
                                    RoomsScreen.this.ostatokMMR = (float)var1 + RoomsScreen.this.mmr_bar.getValue();
                                    RoomsScreen.this.mmr_bar.setValue(0.0F);
                                    Application var12 = Gdx.app;
                                    var7 = new StringBuilder();
                                    var7.append("");
                                    var7.append(var1);
                                    var12.log("RegressBiger", var7.toString());
                                }
                            }

                            RoomsScreen.MMR += var1;
                        } else {
                            var8 = RoomsScreen.this;
                            --var8.NormPotionCount;
                        }
                    } else if (RoomsScreen.this.MMRclassic > 0) {
                        if (RoomsScreen.this.VipPotionCount <= 0) {
                            RoomsScreen.this.SmokEffect = new ParticleEffect();
                            RoomsScreen.this.SmokEffect.load(Gdx.files.internal("particle/smoke"), Gdx.files.internal(""));
                            RoomsScreen.this.SmokEffect.setPosition(115.0F, 275.0F);
                            RoomsScreen.this.SmokEffect.start();
                            var13 = RoomsScreen.this.lastRang;
                            var16 = RoomsScreen.this.game.game;
                            var13.play(MyGame.VOLUME);
                            var8 = RoomsScreen.this;
                            --var8.MMRclassic;
                        } else {
                            var8 = RoomsScreen.this;
                            --var8.VipPotionCount;
                        }
                    }
                }

                if (var1 > 0) {
                    if (var3) {
                        if (var2.equals("ManiacWin")) {
                            var8 = RoomsScreen.this;
                            var8.XYZ += 10 * RoomsScreen.VIP;
                        } else {
                            var8 = RoomsScreen.this;
                            var8.XYZ += 5 * RoomsScreen.VIP;
                        }
                    } else {
                        var8 = RoomsScreen.this;
                        var8.XYZ += 3 * RoomsScreen.VIP;
                    }

                    Label var17 = RoomsScreen.this.LabelMoney;
                    var11 = new StringBuilder();
                    var11.append("");
                    var11.append(RoomsScreen.this.XYZ);
                    var17.setText(var11.toString());
                    if (RoomsScreen.Mod == 0) {
                        var13 = RoomsScreen.this.PrigressSound;
                        var16 = RoomsScreen.this.game.game;
                        var13.play(MyGame.VOLUME);
                        RoomsScreen.this.progressBarStatus = 2;
                        RoomsScreen.this.curentProgress = RoomsScreen.this.mmr_bar.getValue();
                        if (RoomsScreen.this.mmr_bar.getValue() + (float)var1 <= RoomsScreen.this.mmr_bar.getMaxValue()) {
                            RoomsScreen.this.mmr_bar.setAnimateDuration((float)var1 / 3.9F);
                            RoomsScreen.this.mmr_bar.setValue(RoomsScreen.this.mmr_bar.getValue() + (float)var1);
                        } else {
                            RoomsScreen.this.mmr_bar.setAnimateDuration((RoomsScreen.this.mmr_bar.getMaxValue() - RoomsScreen.this.mmr_bar.getValue()) / 3.9F);
                            RoomsScreen.this.ostatokMMR = (float)var1 - (RoomsScreen.this.mmr_bar.getMaxValue() - RoomsScreen.this.mmr_bar.getValue());
                            RoomsScreen.this.mmr_bar.setValue(RoomsScreen.this.mmr_bar.getMaxValue());
                        }

                        RoomsScreen.MMR += var1;
                    } else {
                        RoomsScreen.this.imgIconRole.setOrigin(75.0F, 100.0F);
                        RoomsScreen.this.imgIconRole.addAction(Actions.sequence(Actions.delay(0.7F), Actions.scaleTo(1.4F, 1.4F, 0.4F, Interpolation.exp5), Actions.scaleTo(1.3F, 1.3F, 0.1F, Interpolation.exp5), Actions.scaleTo(1.4F, 1.4F, 0.1F, Interpolation.exp5), Actions.scaleTo(1.0F, 1.0F, 0.5F)));
                        RoomsScreen.this.LvlUpClassic = new ParticleEffect();
                        RoomsScreen.this.LvlUpClassic.load(Gdx.files.internal("particle/LvlUpClassic"), Gdx.files.internal(""));
                        RoomsScreen.this.LvlUpClassic.setPosition(115.0F, 275.0F);
                        RoomsScreen.this.LvlUpClassic.start();
                        var14 = RoomsScreen.this.LvlUpClassicSound;
                        var10 = RoomsScreen.this.game.game;
                        var14.play(MyGame.VOLUME);
                        (new Timer()).scheduleTask(new Timer.Task() {

                            public void run() {
                                RoomsScreen var1 = RoomsScreen.this;
                                ++var1.MMRclassic;
                            }
                        }, 0.6F);
                    }
                }

                RoomsScreen.this.window.remove();
                var6.remove();
                return true;
            }
        };
        var32.addListener(var11);
        ((Table)var17).addListener(var11);
        var19.addListener(var11);
        this.game.getHandler().IsMadLoaded(this.game);
    }

    public void dispose() {
        this.stage.dispose();
    }

    public SkinTexture getActualSkin(ArrayList<SkinTexture> var1) {
        Iterator var2 = var1.iterator();

        SkinTexture var3;
        do {
            if (!var2.hasNext()) {
                return (SkinTexture)var1.get(0);
            }

            var3 = (SkinTexture)var2.next();
        } while(!var3.isActual());

        if (this.skinShirt.size() > 1 && this.game.getScreen().equals(this.game.rooms)) {
            this.ActualShirt.setDrawable(new TextureRegionDrawable(new TextureRegion(var3.getShirt())));
            this.game.rooms.actualSkins.remove(99);
            this.game.rooms.actualSkins.put(99, var3.getShirt().getNameOfTexture());
        } else {
            this.ActualShirt.setDrawable((Drawable)null);
        }

        return var3;
    }

    public int getCountNewTask() {
        FileHandle var1 = Gdx.files.local("tasks.txt");
        int var2;
        if (this.Task1 != null) {
            var2 = 1;
        } else {
            var2 = 0;
        }

        int var3 = var2;
        if (this.Task2 != null) {
            var3 = var2 + 1;
        }

        var2 = var3;
        if (this.Task3 != null) {
            var2 = var3 + 1;
        }

        if (Gdx.files.local("tasks.txt").exists()) {
            label23: {
                try {
                    var3 = Integer.parseInt(var1.readString());
                } catch (NumberFormatException var5) {
                    var3 = 0;
                    break label23;
                }

                var3 = var2 - var3;
            }
        } else {
            var3 = var2;
        }

        var1.writeString(Integer.toString(var2), false);
        return var3;
    }

    public TextureRegion getMyPaints(int var1) {
        boolean var10001;
        RectCart var4;
        label80: {
            label84: {
                try {
                    if (Setting.getMe(Name).getMafia() != 11) {
                        break label84;
                    }
                } catch (Exception var14) {
                    var10001 = false;
                    return null;
                }

                boolean var2 = false;

                Iterator var3;
                try {
                    var3 = Setting.carts.iterator();
                } catch (Exception var12) {
                    var10001 = false;
                    return null;
                }

                var4 = null;

                while(true) {
                    RectCart var5;
                    label72: {
                        try {
                            while(var3.hasNext()) {
                                var5 = (RectCart)var3.next();
                                if (var5.getSettled()) {
                                    break label72;
                                }
                            }
                        } catch (Exception var13) {
                            var10001 = false;
                            return null;
                        }

                        if (!var2) {
                            try {
                                var4 = Setting.getMe(Name);
                            } catch (Exception var11) {
                                var10001 = false;
                                return null;
                            }
                        }
                        break label80;
                    }

                    var2 = true;
                    var4 = var5;
                }
            }

            try {
                var4 = Setting.getMe(Name);
            } catch (Exception var10) {
                var10001 = false;
                return null;
            }
        }

        try {
            var1 = (Integer)var4.getPaints().get(var1);
        } catch (Exception var9) {
            var10001 = false;
            return null;
        }

        if (var1 != 5) {
            switch (var1) {
                case 0:
                    return null;
                case 1:
                    try {
                        return this.skin.getRegion("PanitRamkaRed");
                    } catch (Exception var7) {
                        var10001 = false;
                        break;
                    }
                case 2:
                    try {
                        return this.skin.getRegion("PanitRamkaYellow");
                    } catch (Exception var6) {
                        var10001 = false;
                        break;
                    }
                default:
                    return null;
            }
        } else {
            try {
                TextureRegion var15 = this.skin.getRegion("PanitRamkaPurple");
                return var15;
            } catch (Exception var8) {
                var10001 = false;
            }
        }

        return null;
    }

    public void getSettingFromJson(JSONObject var1) {
        label173: {
            JSONException var10000;
            label177: {
                boolean var10001;
                label170: {
                    try {
                        if (Mod == 0) {
                            WaitPlayers.numberPlayers = Integer.valueOf(var1.get("numberPlayer").toString());
                            WaitPlayers.numberPlayersInRoom = Integer.valueOf(var1.get("numberPlayersInRoom").toString());
                            WaitPlayers.RoomID = var1.get("id").toString();
                            Setting.KoefMMR = Integer.valueOf(var1.get("KoefMMR").toString());
                            break label170;
                        }
                    } catch (JSONException var20) {
                        var10000 = var20;
                        var10001 = false;
                        break label177;
                    }

                    try {
                        WaitClassic var2 = this.game.waitClassic;
                        WaitClassic.numberPlayers = Integer.valueOf(var1.get("numberPlayer").toString());
                        var2 = this.game.waitClassic;
                        WaitClassic.numberPlayersInRoom = Integer.valueOf(var1.get("numberPlayersInRoom").toString());
                        var2 = this.game.waitClassic;
                        WaitClassic.RoomID = var1.get("id").toString();
                    } catch (JSONException var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label177;
                    }
                }

                JSONArray var24;
                try {
                    Setting.numberPlayer = Integer.valueOf(var1.get("numberPlayer").toString());
                    Setting.numberMafia = Integer.valueOf(var1.get("numberMafia").toString());
                    Setting.numberMafia_real = Setting.numberMafia;
                    Setting.restart();
                    var24 = var1.getJSONArray("RolePlayers");
                } catch (JSONException var16) {
                    var10000 = var16;
                    var10001 = false;
                    break label177;
                }

                int var3 = 0;

                while(true) {
                    label159: {
                        label158: {
                            label157: {
                                label156: {
                                    label155: {
                                        label154: {
                                            label153: {
                                                label152: {
                                                    label151: {
                                                        label150: {
                                                            try {
                                                                if (var3 >= var24.length()) {
                                                                    break;
                                                                }

                                                                switch (Integer.valueOf(var24.get(var3).toString())) {
                                                                    case 3:
                                                                        break label152;
                                                                    case 4:
                                                                        break label151;
                                                                    case 5:
                                                                        break label150;
                                                                    case 6:
                                                                        break;
                                                                    case 7:
                                                                        break label158;
                                                                    case 8:
                                                                        break label157;
                                                                    case 9:
                                                                        break label156;
                                                                    case 10:
                                                                        break label155;
                                                                    case 11:
                                                                        break label154;
                                                                    case 12:
                                                                        break label153;
                                                                    default:
                                                                        break label159;
                                                                }
                                                            } catch (JSONException var19) {
                                                                var10000 = var19;
                                                                var10001 = false;
                                                                break label177;
                                                            }

                                                            try {
                                                                Setting.don = true;
                                                                Setting.don_real = true;
                                                                break label159;
                                                            } catch (JSONException var9) {
                                                                var10000 = var9;
                                                                var10001 = false;
                                                                break label177;
                                                            }
                                                        }

                                                        try {
                                                            Setting.maniac = true;
                                                            Setting.maniac_real = true;
                                                            break label159;
                                                        } catch (JSONException var8) {
                                                            var10000 = var8;
                                                            var10001 = false;
                                                            break label177;
                                                        }
                                                    }

                                                    try {
                                                        Setting.sherif = true;
                                                        Setting.sherif_real = true;
                                                        break label159;
                                                    } catch (JSONException var7) {
                                                        var10000 = var7;
                                                        var10001 = false;
                                                        break label177;
                                                    }
                                                }

                                                try {
                                                    Setting.med = true;
                                                    Setting.med_real = true;
                                                    break label159;
                                                } catch (JSONException var6) {
                                                    var10000 = var6;
                                                    var10001 = false;
                                                    break label177;
                                                }
                                            }

                                            try {
                                                Setting.ninga = true;
                                                Setting.ninga_real = true;
                                                break label159;
                                            } catch (JSONException var15) {
                                                var10000 = var15;
                                                var10001 = false;
                                                break label177;
                                            }
                                        }

                                        try {
                                            Setting.vamp = true;
                                            Setting.vamp_real = true;
                                            break label159;
                                        } catch (JSONException var14) {
                                            var10000 = var14;
                                            var10001 = false;
                                            break label177;
                                        }
                                    }

                                    try {
                                        Setting.vor = true;
                                        Setting.vor_real = true;
                                        break label159;
                                    } catch (JSONException var13) {
                                        var10000 = var13;
                                        var10001 = false;
                                        break label177;
                                    }
                                }

                                try {
                                    Setting.twoface = 1;
                                    Setting.twoface_real = 1;
                                    break label159;
                                } catch (JSONException var12) {
                                    var10000 = var12;
                                    var10001 = false;
                                    break label177;
                                }
                            }

                            try {
                                Setting.bessmert = true;
                                Setting.bessmert_real = true;
                                break label159;
                            } catch (JSONException var11) {
                                var10000 = var11;
                                var10001 = false;
                                break label177;
                            }
                        }

                        try {
                            Setting.putana = true;
                            Setting.putana_real = true;
                        } catch (JSONException var10) {
                            var10000 = var10;
                            var10001 = false;
                            break label177;
                        }
                    }

                    ++var3;
                }

                RoomsScreen var21;
                try {
                    Setting.game_style = Integer.valueOf(var1.get("game_style").toString());
                    Sett.GolosProtiv = false;
                    Setting.resultOfMatch = 0;
                    Setting.myEtapAct = 0;
                    Setting.arMafiaAlreadyAct.clear();
                    Sett.Incognito = var1.getBoolean("Inc");
                    if (var1.has("isFast")) {
                        var21 = this.game.rooms;
                        if (Name.startsWith("[Я")) {
                            Setting.intFastAnalytik = 1;
                            Application var23 = Gdx.app;
                            StringBuilder var25 = new StringBuilder();
                            var25.append(Setting.intFastAnalytik);
                            var25.append("");
                            var23.log("Setting.intFastAnalytik", var25.toString());
                            break label173;
                        }
                    }
                } catch (JSONException var5) {
                    var10000 = var5;
                    var10001 = false;
                    break label177;
                }

                try {
                    var21 = this.game.rooms;
                    if (Name.startsWith("[Я")) {
                        Setting.intFastAnalytik = 10;
                        break label173;
                    }
                } catch (JSONException var18) {
                    var10000 = var18;
                    var10001 = false;
                    break label177;
                }

                try {
                    Setting.intFastAnalytik = 0;
                    break label173;
                } catch (JSONException var4) {
                    var10000 = var4;
                    var10001 = false;
                }
            }

            JSONException var22 = var10000;
            ThrowableExtension.printStackTrace(var22);
        }

        if (this.wait != null && this.wait.hasActions()) {
            this.wait.removeAction((Action)this.wait.getActions().get(0));
        }

        this.game.sett.loadmusic();
        this.container.setTouchable(Touchable.enabled);
    }

    public void hide() {
    }

    public boolean isClassicAvailible() {
        return this.MMRclassic >= 0 && MMR >= 150 && this.SherifBuy > 0 && this.DonBuy > 0 || this.SuperAccessToClassic;
    }

    public boolean isPlayerCanPlay() {
        if (numberDisLike >= 3) {
            if (this.dislikeERR != null) {
                this.dislikeERR.remove();
            }

            this.dislikeERR = new WindowAlotofDislike("", this.skin, numberDisLike, this.game);
            this.stage.addActor(this.dislikeERR);
            return false;
        } else {
            return true;
        }
    }

    public void joinServer(JSONObject var1) {
        Gdx.app.postRunnable(new Runnable() {
            public void run() {
                RoomsScreen.this.getSettingFromJson(var1);
                boolean var21 = TableInRoomScreen.getInstance(RoomsScreen.this.game).isStartSearch();
                int var2 = 0;
                if (var21) {
                    MainMenuScreen.Connect_Class.socket.emit("RemoveSearcher", new Object[0]);
                    TableInRoomScreen.getInstance(RoomsScreen.this.game).btnStartSearch.setDisabled(true);
                }

                MyGame var3 = RoomsScreen.this.game.game;
                MyGame.present = false;
                if (RoomsScreen.Mod == 0) {
                    RoomsScreen.this.game.setScreen(RoomsScreen.this.game.wait);
                } else {
                    RoomsScreen.this.game.setScreen(RoomsScreen.this.game.waitClassic);

                    while(var2 < var1.getJSONArray("NamePlayers").length()) {
                        RoomsScreen.this.game.waitClassic.PersonTable.add(new Label(var1.getJSONArray("NamePlayers").get(var2).toString(), RoomsScreen.this.skin, "chatAuthtor")).padTop(5.0F).center();
                        RoomsScreen.this.game.waitClassic.PersonTable.row();
                        ++var2;
                    }
                }

            }
        });
        this.InFindRooms = false;
    }

    public void joinServerERR(JSONArray var1, int var2) {
        this.container.setTouchable(Touchable.enabled);
        if (this.wait.hasActions()) {
            this.wait.removeAction((Action)this.game.rooms.wait.getActions().get(0));
        }

        TextButton var3;
        Mafia var4;
        Mafia var7;
        TextButton var8;
        switch (var2) {
            case 0:
                var8 = this.message;
                var7 = this.game;
                var8.setText(Mafia.local.get("err_No_place"));
                break;
            case 1:
                var8 = this.message;
                var7 = this.game;
                var8.setText(Mafia.local.get("err_No_name"));
                break;
            case 2:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_game_end"));
                break;
            case 3:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_you_in_group"));
                break;
            case 4:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_find_server_start"));
                break;
            case 5:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_no_group"));
                break;
            case 6:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_group_full"));
                break;
            case 7:
                var3 = this.message;
                var4 = this.game;
                var3.setText(Mafia.local.get("err_group_inFind"));
                break;
            default:
                switch (var2) {
                    case 20:
                        var8 = this.message;
                        var7 = this.game;
                        var8.setText(Mafia.local.get("err_player_inGroup"));
                        break;
                    case 21:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("err_player_leave_party"));
                        break;
                    case 22:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("err_role_don_notUniq"));
                        break;
                    case 23:
                        var8 = this.message;
                        var7 = this.game;
                        var8.setText(Mafia.local.get("err_try_after_minut"));
                        break;
                    case 24:
                        var8 = this.message;
                        var7 = this.game;
                        var8.setText(Mafia.local.get("err_find_not_work"));
                        break;
                    case 25:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("err_not_all_ready"));
                        break;
                    case 26:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("mailCodeOK"));
                        break;
                    case 27:
                        var8 = this.message;
                        var7 = this.game;
                        var8.setText(Mafia.local.get("mailCodeERR"));
                        break;
                    case 28:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("checkMail_ERR"));
                        break;
                    case 29:
                        var3 = this.message;
                        var4 = this.game;
                        var3.setText(Mafia.local.get("checkMail_ERR_time"));
                }
        }

        this.message.setHeight(80.0F);
        this.message.setX(210.0F);
        this.message.setY(620.0F);
        if (var2 >= 20) {
            this.message.setWidth(380.0F);
        } else {
            this.message.setWidth(320.0F);
        }

        if (var2 == 24) {
            this.message.setX(50.0F);
            this.message.setWidth(700.0F);
        }

        if (var2 == 25) {
            this.message.setX(100.0F);
            this.message.setWidth(600.0F);
        }

        byte var5 = 2;
        if (var2 == 28 || var2 == 29) {
            this.message.setHeight(110.0F);
            this.message.setWidth(800.0F);
            this.message.setX(0.0F);
            var5 = 4;
        }

        this.stage.addActor(this.message);
        this.message.addAction(Actions.sequence(Actions.moveTo(this.message.getX(), this.message.getY() - this.message.getHeight() - 120.0F, 0.4F), Actions.delay((float)var5), Actions.moveTo(this.message.getX(), this.message.getY() + this.message.getHeight(), 0.7F)));
        if (var1 != null) {
            try {
                this.AddAllServers(var1, false);
            } catch (JSONException var6) {
                ThrowableExtension.printStackTrace(var6);
            }
        }

    }

    public JSONObject makeJsonToJoin(String var1) {
        JSONObject var2 = new JSONObject();

        JSONException var10000;
        label55: {
            boolean var10001;
            label56: {
                try {
                    var2.put("room", var1);
                    var2.put("name", Name);
                    var2.put("role", this.Role);
                    var2.put("mmr", MMR);
                    var2.put("money", this.XYZ);
                    var2.put("hat", hat);
                    var2.put("medal", medal);
                    var2.put("VIP", VIP);
                    var2.put("skinRole", this.game.rooms.actualSkins.get(this.Role));
                    var2.put("skinShirt", this.game.rooms.actualSkins.get(99));
                    if (MMR < 100) {
                        Random var8 = new Random();
                        var2.put("percentWin", 50 + var8.nextInt(25));
                        break label56;
                    }
                } catch (JSONException var7) {
                    var10000 = var7;
                    var10001 = false;
                    break label55;
                }

                try {
                    var2.put("percentWin", getPercentWin());
                } catch (JSONException var5) {
                    var10000 = var5;
                    var10001 = false;
                    break label55;
                }
            }

            try {
                if (this.game.rooms.Role == 5) {
                    var2.put("maniacWithBandage", this.game.rooms.haveBadge);
                }
            } catch (JSONException var4) {
                var10000 = var4;
                var10001 = false;
                break label55;
            }

            try {
                var2.put("like", numberLike);
                var2.put("dislike", numberDisLike);
                if (this.NormPotionCount > 0) {
                    var2.put("potion", true);
                    return var2;
                }
            } catch (JSONException var6) {
                var10000 = var6;
                var10001 = false;
                break label55;
            }

            try {
                var2.put("potion", false);
                return var2;
            } catch (JSONException var3) {
                var10000 = var3;
                var10001 = false;
            }
        }

        JSONException var9 = var10000;
        ThrowableExtension.printStackTrace(var9);
        return var2;
    }

    public void pause() {
    }

    public void render(float var1) {
        this.camera.update();
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.stage.draw();
        this.stage.act(Gdx.graphics.getDeltaTime());
        this.game.batch.begin();
        Label var2;
        StringBuilder var3;
        Sound var5;
        StringBuilder var6;
        MyGame var7;
        switch (this.progressBarStatus) {
            case 0:
            default:
                break;
            case 1:
                if (this.curentProgress == 0.0F) {
                    var5 = this.lastRang;
                    var7 = this.game.game;
                    var5.play(MyGame.VOLUME);
                    this.SmokEffect = new ParticleEffect();
                    this.SmokEffect.load(Gdx.files.internal("particle/smoke"), Gdx.files.internal(""));
                    this.SmokEffect.setPosition(40.0F, 410.0F);
                    this.SmokEffect.start();
                    --MyRating;
                    Image var10 = this.rating;
                    Skin var8 = this.skin;
                    var3 = new StringBuilder();
                    var3.append("Lvl");
                    var3.append(MyRating);
                    var10.setDrawable(var8, var3.toString());
                    if (MMR < 180) {
                        this.mmr_bar.setRange(0.0F, 30.0F);
                    }

                    if (MMR >= 180 && MMR < 380) {
                        this.mmr_bar.setRange(0.0F, 40.0F);
                    }

                    if (MMR >= 380 && MMR < 630) {
                        this.mmr_bar.setRange(0.0F, 50.0F);
                    }

                    if (MMR >= 630 && MMR < 1230) {
                        this.mmr_bar.setRange(0.0F, 60.0F);
                    }

                    if (MMR >= 1230 && MMR < 1730) {
                        this.mmr_bar.setRange(0.0F, 100.0F);
                    }

                    if (MMR >= 1730 && MMR < 5230) {
                        this.mmr_bar.setRange(0.0F, 700.0F);
                    }

                    if (MMR >= 5230) {
                        this.mmr_bar.setRange(0.0F, 700.0F);
                    }

                    Label var11 = this.mmr_label;
                    var6 = new StringBuilder();
                    var6.append(Math.round(this.mmr_bar.getMaxValue()));
                    var6.append("/");
                    var6.append(Math.round(this.mmr_bar.getMaxValue()));
                    var11.setText(var6.toString());
                    this.mmr_bar.setAnimateDuration(0.0F);
                    this.mmr_bar.setValue(this.mmr_bar.getMaxValue());
                    this.mmr_bar.act(100.0F);
                    this.mmr_bar.setAnimateDuration(-(this.ostatokMMR / 3.9F));
                    this.mmr_bar.setValue(this.mmr_bar.getMaxValue() + this.ostatokMMR);
                    this.curentProgress = this.mmr_bar.getMaxValue();
                    this.ostatokMMR = 0.0F;
                } else if (this.curentProgress > this.mmr_bar.getValue()) {
                    this.curentProgress -= 0.1F;
                    if (this.curentProgress > this.mmr_bar.getValue()) {
                        var2 = this.mmr_label;
                        var3 = new StringBuilder();
                        var3.append(Math.round(this.curentProgress));
                        var3.append("/");
                        var3.append(Math.round(this.mmr_bar.getMaxValue()));
                        var2.setText(var3.toString());
                    } else if (this.ostatokMMR != 0.0F) {
                        this.curentProgress = 0.0F;
                        this.progressBarStatus = 1;
                    } else {
                        this.progressBarStatus = 0;
                        this.RegressSound.stop();
                    }
                }
                break;
            case 2:
                if (this.curentProgress <= this.mmr_bar.getValue()) {
                    this.curentProgress += 0.1F;
                    if (this.curentProgress < this.mmr_bar.getValue()) {
                        var2 = this.mmr_label;
                        var3 = new StringBuilder();
                        var3.append(Math.round(this.curentProgress));
                        var3.append("/");
                        var3.append(Math.round(this.mmr_bar.getMaxValue()));
                        var2.setText(var3.toString());
                    } else {
                        this.progressBarStatus = 0;
                        if (this.mmr_bar.getValue() == this.mmr_bar.getMaxValue() && MyRating != 35) {
                            var5 = this.newRang;
                            var7 = this.game.game;
                            var5.play(MyGame.VOLUME);
                            this.FireEffect = new ParticleEffect();
                            this.FireEffect.load(Gdx.files.internal("particle/fire"), Gdx.files.internal(""));
                            this.FireEffect.setPosition(43.0F, 400.0F);
                            this.FireEffect.start();
                            ++MyRating;
                            Image var9 = this.rating;
                            Skin var4 = this.skin;
                            var6 = new StringBuilder();
                            var6.append("Lvl");
                            var6.append(MyRating);
                            var9.setDrawable(var4, var6.toString());
                            this.mmr_bar.setAnimateDuration(0.0F);
                            this.mmr_bar.setValue(0.0F);
                            this.mmr_bar.act(1.0F);
                            if (MMR < 180) {
                                this.mmr_bar.setRange(0.0F, 30.0F);
                            }

                            if (MMR >= 180 && MMR < 380) {
                                this.mmr_bar.setRange(0.0F, 40.0F);
                            }

                            if (MMR >= 380 && MMR < 630) {
                                this.mmr_bar.setRange(0.0F, 50.0F);
                            }

                            if (MMR >= 630 && MMR < 1230) {
                                this.mmr_bar.setRange(0.0F, 60.0F);
                            }

                            if (MMR >= 1230 && MMR < 1730) {
                                this.mmr_bar.setRange(0.0F, 100.0F);
                            }

                            if (MMR >= 1730) {
                                this.mmr_bar.setRange(0.0F, 700.0F);
                            }

                            var2 = this.mmr_label;
                            var3 = new StringBuilder();
                            var3.append("0/");
                            var3.append(Math.round(this.mmr_bar.getMaxValue()));
                            var2.setText(var3.toString());
                        }

                        if (this.ostatokMMR != 0.0F && MyRating != 35) {
                            this.mmr_bar.setAnimateDuration(0.0F);
                            this.mmr_bar.setValue(0.0F);
                            this.mmr_bar.act(1.0F);
                            this.curentProgress = 0.0F;
                            this.mmr_bar.setAnimateDuration(this.ostatokMMR / 3.9F);
                            this.mmr_bar.setValue(this.ostatokMMR);
                            this.progressBarStatus = 2;
                            this.ostatokMMR = 0.0F;
                        } else {
                            this.PrigressSound.stop();
                        }
                    }
                }
        }

        if (Mod == 1 && !this.NotvisibleNumber && this.isClassicAvailible()) {
            if (this.MMRclassic < 10) {
                this.game.fontNumber.draw(this.game.batch, Integer.toString(this.MMRclassic), 107.0F, 280.0F);
            }

            if (this.MMRclassic >= 10 && this.MMRclassic < 100) {
                this.game.fontNumber.draw(this.game.batch, Integer.toString(this.MMRclassic), 93.0F, 280.0F);
            }

            if (this.MMRclassic >= 100) {
                this.game.fontNumber.draw(this.game.batch, Integer.toString(this.MMRclassic), 80.0F, 280.0F);
            }
        }

        this.SmokEffect.draw(this.game.batch, var1);
        this.FireEffect.draw(this.game.batch, var1);
        this.PufEffect.draw(this.game.batch, var1);
        this.ChangeMode.draw(this.game.batch, var1);
        this.LvlUpClassic.draw(this.game.batch, var1);
        this.OpenChestEffect.draw(this.game.batch, var1);
        this.game.batch.end();
    }

    public void resize(int var1, int var2) {
    }

    public void resume() {
    }

    public void setNumberOnline(int var1) {
        Label var2 = this.NumberOnline;
        StringBuilder var3 = new StringBuilder();
        Mafia var4 = this.game;
        var3.append(Mafia.local.get("players_online2"));
        var3.append(" ");
        var3.append(var1);
        var2.setText(var3.toString());
    }

    public void setTask(int var1, Task var2) {
        Application var3 = Gdx.app;
        StringBuilder var4 = new StringBuilder();
        var4.append("index = ");
        var4.append(var1);
        var3.log("setTask", var4.toString());
        switch (var1) {
            case 0:
                this.Task3 = var2;
                break;
            case 1:
                this.Task2 = var2;
                break;
            case 2:
                this.Task1 = var2;
        }

    }

    public void show() {
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800.0F, 480.0F);
        this.viewport = new StretchViewport(800.0F, 480.0F, this.camera);
        this.stage = new MafiaStage(this.viewport, this.game.batch);
        this.stage.name = "rooms";
        MyGame var1 = this.game.game;
        Image var7 = new Image(MyGame.FonRoomJapan);
        var7.setFillParent(true);
        this.stage.addActor(var7);
        this.skin = this.game.game.skin;
        Gdx.input.setInputProcessor(this.stage);
        boolean var2 = this.InFindRooms;
        this.InFindRooms = true;
        MainMenuScreen.Connect_Class.socket.emit("NumberOnline", new Object[0]);
        this.stage.addActor(this.container);
        if (OldMMR != 0) {
            this.UpdateWindow(3);
        }

        this.GreyI.setPosition(0.0F, 490.0F);
        this.magazin.setPosition(50.0F, 490.0F);
        this.stage.addActor(this.GreyI);
        this.stage.addActor(this.magazin);
        Skin var3;
        StringBuilder var4;
        if (MMR < 180) {
            this.MaxMMr = 30;
            MyRating = MMR / this.MaxMMr;
            var7 = this.rating;
            var3 = this.skin;
            var4 = new StringBuilder();
            var4.append("Lvl");
            var4.append(MyRating);
            var7.setDrawable(var3, var4.toString());
            this.curentMMr = MMR - MyRating * this.MaxMMr;
        }

        Skin var8;
        StringBuilder var10;
        Image var12;
        if (MMR >= 180 && MMR < 380) {
            this.MaxMMr = 40;
            MyRating = (MMR - 180) / this.MaxMMr + 6;
            var12 = this.rating;
            var8 = this.skin;
            var10 = new StringBuilder();
            var10.append("Lvl");
            var10.append(MyRating);
            var12.setDrawable(var8, var10.toString());
            this.curentMMr = MMR - (180 + (MyRating - 6) * this.MaxMMr);
        }

        if (MMR >= 380 && MMR < 630) {
            this.MaxMMr = 50;
            MyRating = 11 + (MMR - 380) / this.MaxMMr;
            Image var11 = this.rating;
            var8 = this.skin;
            var4 = new StringBuilder();
            var4.append("Lvl");
            var4.append(MyRating);
            var11.setDrawable(var8, var4.toString());
            this.curentMMr = MMR - (380 + (MyRating - 11) * this.MaxMMr);
        }

        StringBuilder var9;
        if (MMR >= 630 && MMR < 1230) {
            this.MaxMMr = 60;
            MyRating = 16 + (MMR - 630) / this.MaxMMr;
            var12 = this.rating;
            var3 = this.skin;
            var9 = new StringBuilder();
            var9.append("Lvl");
            var9.append(MyRating);
            var12.setDrawable(var3, var9.toString());
            this.curentMMr = MMR - ((MyRating - 16) * this.MaxMMr + 630);
        }

        if (MMR >= 1230 && MMR < 1730) {
            this.MaxMMr = 100;
            MyRating = 26 + (MMR - 1230) / this.MaxMMr;
            var7 = this.rating;
            var3 = this.skin;
            var4 = new StringBuilder();
            var4.append("Lvl");
            var4.append(MyRating);
            var7.setDrawable(var3, var4.toString());
            this.curentMMr = MMR - (1230 + (MyRating - 26) * this.MaxMMr);
        }

        Skin var13;
        if (MMR >= 1730 && MMR < 5230) {
            this.MaxMMr = 700;
            MyRating = 31 + (MMR - 1730) / this.MaxMMr;
            var7 = this.rating;
            var13 = this.skin;
            var10 = new StringBuilder();
            var10.append("Lvl");
            var10.append(MyRating);
            var7.setDrawable(var13, var10.toString());
            this.curentMMr = MMR - (1730 + (MyRating - 31) * this.MaxMMr);
        }

        if (MMR >= 5230) {
            this.MaxMMr = 700;
            MyRating = 35;
            this.curentMMr = 700;
            var7 = this.rating;
            var13 = this.skin;
            var10 = new StringBuilder();
            var10.append("Lvl");
            var10.append(MyRating);
            var7.setDrawable(var13, var10.toString());
        }

        this.curentProgress = (float)this.curentMMr;
        this.mmr_bar.setRange(0.0F, (float)this.MaxMMr);
        this.mmr_bar.setAnimateDuration(0.0F);
        this.mmr_bar.setValue((float)this.curentMMr);
        this.mmr_bar.setAnimateDuration(2.0F);
        Label var15 = this.mmr_label;
        var9 = new StringBuilder();
        var9.append(Math.round(this.mmr_bar.getValue()));
        var9.append("/");
        var9.append(Math.round(this.mmr_bar.getMaxValue()));
        var15.setText(var9.toString());
        if (this.colorNick.equals("[#ffff80]")) {
            this.name.setText(Name);
        } else {
            var15 = this.name;
            var9 = new StringBuilder();
            var9.append(this.colorNick);
            var9.append(Name);
            var15.setText(var9.toString());
        }

        var15 = this.LabelMoney;
        var9 = new StringBuilder();
        var9.append(this.XYZ);
        var9.append("");
        var15.setText(var9.toString());
        if (allServers != null) {
            try {
                this.AddAllServers(allServers, false);
                allServers = null;
            } catch (JSONException var6) {
                ThrowableExtension.printStackTrace(var6);
            }
        }

        Application var14;
        label178: {
            var1 = this.game.game;
            if (!MyGame.restart || Setting.KoefMMR != 2) {
                var1 = this.game.game;
                if (!MyGame.restart || Mod != 1) {
                    break label178;
                }
            }

            var14 = Gdx.app;
            var4 = new StringBuilder();
            var4.append("ResultOfEnd = ");
            var4.append(Setting.ResultOfEnd);
            var14.log("Restart", var4.toString());
            if (Setting.ResultOfEnd.equals("MafiaLose")) {
                if (MMR < 30) {
                    this.WindowWinLose(0, "MafiaLose", false);
                }

                if (MMR >= 30 && MMR < 630) {
                    this.WindowWinLose(-Math.round((float)(Setting.numberPlayer / 2)), "MafiaLose", false);
                }

                if (MMR >= 630) {
                    this.WindowWinLose(-Setting.numberPlayer, "MafiaLose", false);
                }
            }

            if (Setting.ResultOfEnd.equals("MafiaWin5")) {
                this.WindowWinLose(Math.round((float)(Setting.numberPlayer / 2 * Setting.KoefMMR)), "MafiaWin", false);
            }

            if (Setting.ResultOfEnd.equals("MafiaWin10")) {
                this.WindowWinLose(Setting.numberPlayer * Setting.KoefMMR, "MafiaWin", true);
            }

            if (Setting.ResultOfEnd.equals("MirnieLose")) {
                if (MMR < 30) {
                    this.WindowWinLose(0, "MirnieLose", false);
                }

                if (MMR >= 30 && MMR < 630) {
                    this.WindowWinLose(-Math.round((float)(Setting.numberPlayer / 2)), "MirnieLose", false);
                }

                if (MMR >= 630) {
                    this.WindowWinLose(-Setting.numberPlayer, "MirnieLose", false);
                }
            }

            if (Setting.ResultOfEnd.equals("MirnieWin5")) {
                this.WindowWinLose(Math.round((float)(Setting.numberPlayer / 2 * Setting.KoefMMR)), "MirnieWin", false);
            }

            if (Setting.ResultOfEnd.equals("MirnieWin10")) {
                this.WindowWinLose(Setting.numberPlayer * Setting.KoefMMR, "MirnieWin", true);
            }

            if (Setting.ResultOfEnd.equals("ManiacLose")) {
                if (MMR < 30) {
                    this.WindowWinLose(0, "ManiacLose", false);
                }

                if (MMR >= 30 && MMR < 630) {
                    this.WindowWinLose(-Math.round((float)(Setting.numberPlayer / 2)), "ManiacLose", false);
                }

                if (MMR >= 630) {
                    this.WindowWinLose(-Setting.numberPlayer, "ManiacLose", false);
                }
            }

            if (Setting.ResultOfEnd.equals("ManiacWin")) {
                this.WindowWinLose(Setting.numberPlayer * 2 * Setting.KoefMMR, "ManiacWin", true);
            }
        }

        Setting.ResultOfEnd = "notEnd";
        if (this.InFindRooms && Mod == 0) {
            this.updateIcon(this.Role);
            MainMenuScreen.Connect_Class.socket.emit("NumberSearchersOfRole", new Object[]{this.Role});
        }

        this.InFindRooms = true;
        if (Mod == 1) {
            this.NextRole.setTouchable(Touchable.disabled);
            this.PriviousRole.setTouchable(Touchable.disabled);
        } else {
            this.NextRole.setTouchable(Touchable.enabled);
            this.PriviousRole.setTouchable(Touchable.enabled);
        }

        if (this.windowOfferToReturn != null) {
            this.stage.addActor(this.windowOfferToReturn);
            this.windowOfferToReturn = null;
        } else if (this.isPlayerCanPlay()) {
            int var5 = this.getCountNewTask();
            var14 = Gdx.app;
            var4 = new StringBuilder();
            var4.append("countnewTask = ");
            var4.append(var5);
            var14.log("countnewTask", var4.toString());
            if (var5 > 0) {
                this.taskScreen = new TaskScreen(this.Task1, this.Task2, this.Task3, var5, this.game);
                this.stage.addActor(this.taskScreen);
            } else if (this.mail.equals("") && MMR > 30) {
                MafiaStage var16 = this.stage;
                Mafia var18 = this.game;
                var16.addActor(new WindowAddEmail(Mafia.local.get("enter_mail"), this.skin, this.game));
            }
        }

        if (this.phone.equals("0")) {
            Mafia var17 = this.game;
            String var19 = Mafia.local.get("window_title_accept");
            var17 = this.game;
            new WindowScrollPolici(var19, Mafia.local.get("PoliciRulles"), this.game, this.stage, true);
        }

        this.stage.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(0.5F), Actions.run(new Runnable() {
            public void run() {
                if (!Gdx.files.local("updateJap.txt").exists()) {
                    Gdx.files.local("updateJap.txt").writeString("1", true);
                    new WindowUpdateNinga(RoomsScreen.this.skin, RoomsScreen.this.game, RoomsScreen.this.stage);
                } else {
                    new HelpWindow(RoomsScreen.this.stage, 17, RoomsScreen.this.game.rooms.Create, RoomsScreen.this.game);
                }

            }
        })));
        this.stage.act();
    }

    public void test() {
    }

    public boolean updateIcon(int var1) {
        boolean var2;
        label94: {
            label93: {
                this.table.clear();
                switch (var1) {
                    case 1:
                        if (MMR >= 30) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinMafia))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.imgIconRole.setDrawable(this.skin.getDrawable("mafiaClose"));
                        this.Create.setDisabled(true);
                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        break;
                    case 2:
                        this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinMirn))));
                        this.Create.setDisabled(false);
                        this.table.add(TableInRoomScreen.getInstance(this.game));
                        break label93;
                    case 3:
                        if (this.MedBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinDoctor))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "doctorClose");
                        break;
                    case 4:
                        if (this.SherifBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinSherif))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.imgIconRole.setColor(1.0F, 1.0F, 1.0F, 1.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "sherifClose");
                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        break;
                    case 5:
                        if (this.ManiacBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinManiac))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "maniacClose");
                        break;
                    case 6:
                        if (this.DonBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinDon))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "donClose");
                        break;
                    case 7:
                        if (this.PutanaBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinPutana))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "putanaClose");
                        break;
                    case 8:
                        if (this.BessmertBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinBessmert))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "bessmertClose");
                        break;
                    case 9:
                        if (this.TwoFaceBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.getActualSkin(this.skinTwoFace))));
                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "twofaceClose");
                        break;
                    case 10:
                        if (this.VorBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.VorI)));
                            if (this.skinShirt.size() > 1 && this.game.getScreen().equals(this.game.rooms)) {
                                this.ActualShirt.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.VorI.getShirt())));
                                this.game.rooms.actualSkins.remove(99);
                                this.game.rooms.actualSkins.put(99, this.game.game.VorI.getShirt().getNameOfTexture());
                            }

                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "VorClose");
                        break;
                    case 11:
                        if (this.VampBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.VampI)));
                            if (this.skinShirt.size() > 1 && this.game.getScreen().equals(this.game.rooms)) {
                                this.ActualShirt.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.VampI.getShirt())));
                                this.game.rooms.actualSkins.remove(99);
                                this.game.rooms.actualSkins.put(99, this.game.game.VampI.getShirt().getNameOfTexture());
                            }

                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "vampClose");
                        break;
                    case 12:
                        if (this.NingaBuy > 0) {
                            this.imgIconRole.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.NingaI)));
                            if (this.skinShirt.size() > 1 && this.game.getScreen().equals(this.game.rooms)) {
                                this.ActualShirt.setDrawable(new TextureRegionDrawable(new TextureRegion(this.game.game.NingaI.getShirt())));
                                this.game.rooms.actualSkins.remove(99);
                                this.game.rooms.actualSkins.put(99, this.game.game.NingaI.getShirt().getNameOfTexture());
                            }

                            this.Create.setDisabled(false);
                            this.table.add(TableInRoomScreen.getInstance(this.game));
                            break label93;
                        }

                        this.table.add(new TableRoleDescription(this.game, var1, this.XYZ)).padLeft(30.0F);
                        this.Create.setDisabled(true);
                        this.imgIconRole.setDrawable(this.skin, "NingaClose");
                }

                var2 = false;
                break label94;
            }

            var2 = true;
        }

        if (var2) {
            TableInRoomScreen.getInstance(this.game).btnStartSearch.setDisabled(false);
        } else {
            TableInRoomScreen.getInstance(this.game).btnStartSearch.setDisabled(true);
        }

        TableInRoomScreen.getInstance(this.game).updateFriends();
        return var2;
    }

    public void updateServers(JSONArray var1) {
        this.container.setTouchable(Touchable.enabled);
        if (this.wait.hasActions()) {
            this.wait.removeAction((Action)this.wait.getActions().get(0));
        }

        if (!TableInRoomScreen.getInstance(this.game).isInParty() && !TableInRoomScreen.getInstance(this.game).isStartSearch()) {
            try {
                this.AddAllServers(var1, false);
            } catch (JSONException var2) {
                ThrowableExtension.printStackTrace(var2);
            }
        }

    }

    public class CreateServerListener extends ChangeListener {
        final RoomsScreen this$0;

        public CreateServerListener(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public void changed(ChangeListener.ChangeEvent var1, Actor var2) {
            if (!TableInRoomScreen.getInstance(this.this$0.game).isInParty()) {
                if (!TableInRoomScreen.getInstance(this.this$0.game).isStartSearch()) {
                    if (this.this$0.game.rooms.Role != 11) {
                        MyGame var5 = this.this$0.game.game;
                        Sound var7 = MyGame.buttonSound;
                        var5 = this.this$0.game.game;
                        var7.play(MyGame.VOLUME);
                        game.setScreen(game.sett);
                        InFindRooms = false;
                        /* ОКНО ВВОДА ИМЕНИ И ПАРОЛЯ ДЛЯ СОЗДАНИЯ СЕРВЕРА КЛАССИКИ
                        MyTextInputListener var8 = this.this$0.new MyTextInputListener(this.this$0);
                        Input var6 = Gdx.input;
                        Mafia var3 = this.this$0.game;
                        String var9 = Mafia.local.get("name_of_server");
                        Mafia var4 = this.this$0.game;
                        var6.getTextInput(var8, var9, "", Mafia.local.get("enter_name_of_server")); */
                    }
                } else {
                    this.this$0.joinServerERR((JSONArray)null, 4);
                }
            } else {
                this.this$0.joinServerERR((JSONArray)null, 3);
            }

        }
    }

    public class INPasswordClassic implements Input.TextInputListener {
        final JSONArray data;
        final int finalI;
        final RoomsScreen this$0;

        public INPasswordClassic(RoomsScreen var1, JSONArray var2, int var3) {
            this.this$0 = var1;
            this.data = var2;
            this.finalI = var3;
        }

        public void canceled() {
        }

        public void input(String var1) {
            if (var1.equals("")) {
                this.canceled();
            }

            if (var1.equals(this.data.getJSONObject(this.finalI).get("pass").toString())) {
                JSONArray var4 = this.data.getJSONObject(this.finalI).getJSONArray("RoleNeed");
                this.this$0.Role = Integer.valueOf(var4.get((int)Math.floor(Math.random() * (double)var4.length())).toString());
                this.this$0.container.setTouchable(Touchable.disabled);
                JSONObject var5 = new JSONObject();

                try {
                    var5.put("room", this.data.getJSONObject(this.finalI).get("id"));
                    var5.put("name", RoomsScreen.Name);
                    var5.put("role", this.this$0.Role);
                    var5.put("mmr", this.this$0.MMRclassic);
                    var5.put("money", this.this$0.XYZ);
                    var5.put("hat", RoomsScreen.hat);
                    var5.put("medal", RoomsScreen.medal);
                    var5.put("VIP", RoomsScreen.VIP);
                    var5.put("percentWin", RoomsScreen.getPercentWin());
                    var5.put("like", RoomsScreen.numberLike);
                    var5.put("dislike", RoomsScreen.numberDisLike);
                    var5.put("skinRole", this.this$0.game.rooms.actualSkins.get(this.this$0.Role));
                    var5.put("skinShirt", this.this$0.game.rooms.actualSkins.get(99));
                    if (this.this$0.VipPotionCount > 0) {
                        var5.put("potion", true);
                    } else {
                        var5.put("potion", false);
                    }
                } catch (JSONException var3) {
                    ThrowableExtension.printStackTrace(var3);
                }

                MainMenuScreen.Connect_Class.socket.emit("JoinServer", new Object[]{var5});
                this.this$0.wait.setOrigin(30.0F, 30.0F);
                this.this$0.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
            }

        }
    }

    public class InviteFriendship implements Input.TextInputListener {
        final RoomsScreen this$0;

        public InviteFriendship(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public void canceled() {
        }

        public void input(String var1) {
            if (var1.equals("")) {
                this.canceled();
            } else {
                String[] var2 = this.this$0.MyFriends.split("\\|");
                int var3 = 0;

                boolean var6;
                while(true) {
                    if (var3 >= var2.length) {
                        var6 = true;
                        break;
                    }

                    if (var2[var3].equals(var1)) {
                        var6 = false;
                        break;
                    }

                    ++var3;
                }

                if (var6) {
                    JSONObject var5 = new JSONObject();

                    try {
                        var5.put("friend", var1);
                        var5.put("name", RoomsScreen.Name);
                    } catch (JSONException var4) {
                        ThrowableExtension.printStackTrace(var4);
                    }

                    MainMenuScreen.Connect_Class.socket.emit("InviteFriendship", new Object[]{var5});
                }
            }

        }
    }

    public class MyTextInputListener implements Input.TextInputListener {
        final RoomsScreen this$0;

        public MyTextInputListener(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public void canceled() {
        }

        public void input(String var1) {
            if (!var1.equals("") && !var1.contains("хуй") && !var1.contains("пизд") && !var1.contains("сук") && !var1.contains("бля") && !var1.contains("муда") && !var1.contains("ебат") && !var1.contains("заебись") && !var1.contains("хуе") && !var1.contains("хуё") && !var1.contains("заеб") && !var1.contains("заёб") && !var1.contains("ебал") && !var1.contains("уебок") && !var1.contains("уёбок") && !var1.contains("ебал") && !var1.contains("уебище") && !var1.contains("уёбище") && !var1.contains("ебан") && !var1.contains("ебан") && !var1.contains("охуе") && !var1.contains("ебну") && !var1.contains("ёбну") && !var1.contains("хуя") && !var1.contains("хуи") && !var1.contains("хуе") && !var1.contains("хуё") && !var1.contains("пизт") && !var1.contains("ебан") && !var1.contains("уебо") && !var1.contains("уёбо") && !var1.contains("мудак") && !var1.contains("гандон") && !var1.contains("[") && !var1.contains("]")) {
                if (!var1.contains(" ") && !var1.contains("_") && !var1.contains("[")) {
                    var1.contains("]");
                }

                String var2 = var1;
                if (var1.length() > 12) {
                    var2 = var1.substring(0, 12);
                }

                RoomsScreen.Name_of_server = var2;
                Sett.zagruzka_music = true;
                Gdx.app.postRunnable(new Runnable() {

                    public void run() {
                        this$0.InFindRooms = false;
                        if (this$0.isClassicAvailible() && RoomsScreen.Mod == 1) {
                            if (this$0.PasswordBuy) {
                                PasswordClassic var1 = this$0.new PasswordClassic(this$0);
                                Input var2 = Gdx.input;
                                Mafia var3 = this$0.game;
                                String var4 = Mafia.local.get("password_from_server");
                                var3 = this$0.game;
                                var2.getTextInput(var1, var4, "", Mafia.local.get("enter_password_from_server"));
                            } else {
                                this$0.container.setTouchable(Touchable.disabled);
                                this$0.wait.setOrigin(30.0F, 30.0F);
                                this$0.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                                this$0.Role = -1;

                                try {
                                    MainMenuScreen.Connect_Class.Comand_to_Server(this$0.game);
                                } catch (JSONException var5) {
                                    ThrowableExtension.printStackTrace(var5);
                                }
                            }
                        }

                    }
                });
                this.this$0.game.sett.loadmusic();
            } else {
                this.canceled();
            }

        }
    }

    public class PasswordClassic implements Input.TextInputListener {
        final RoomsScreen this$0;

        public PasswordClassic(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public void canceled() {
            this.this$0.container.setTouchable(Touchable.disabled);
            this.this$0.wait.setOrigin(30.0F, 30.0F);
            this.this$0.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
            this.this$0.Role = -1;

            try {
                MainMenuScreen.Connect_Class.Comand_to_Server(this.this$0.game);
            } catch (JSONException var2) {
                ThrowableExtension.printStackTrace(var2);
            }

            RoomsScreen.pass = "выпердыш007";
        }

        public void input(String var1) {
            if (var1.equals("")) {
                this.canceled();
            } else {
                RoomsScreen.pass = var1;
                this.this$0.container.setTouchable(Touchable.disabled);
                this.this$0.wait.setOrigin(30.0F, 30.0F);
                this.this$0.wait.addAction(Actions.forever(Actions.rotateBy(360.0F, 1.0F)));
                this.this$0.Role = -1;

                try {
                    MainMenuScreen.Connect_Class.Comand_to_Server(this.this$0.game);
                } catch (JSONException var2) {
                    ThrowableExtension.printStackTrace(var2);
                }

                RoomsScreen.pass = "выпердыш007";
            }

        }
    }

    class QGameStyleListn extends InputListener {
        final RoomsScreen this$0;

        QGameStyleListn(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 10;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    public final class QListner extends InputListener {
        final RoomsScreen this$0;

        public QListner(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (RoomsScreen.Mod == 0) {
                switch (this.this$0.Role) {
                    case 1:
                        if (this.this$0.skinMafia.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (RoomsScreen.MMR >= 30) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 2:
                        if (this.this$0.skinMirn.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        }
                        break;
                    case 3:
                        if (this.this$0.MedBuy > 0 && this.this$0.skinDoctor.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.MedBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 4:
                        if (this.this$0.SherifBuy > 0 && this.this$0.skinSherif.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.SherifBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 5:
                        if (this.this$0.ManiacBuy > 0 && this.this$0.skinManiac.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.ManiacBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 6:
                        if (this.this$0.DonBuy > 0 && this.this$0.skinDon.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.DonBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 7:
                        if (this.this$0.PutanaBuy > 0 && this.this$0.skinPutana.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = this.this$0.Role;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.PutanaBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 8:
                        if (this.this$0.BessmertBuy > 0 && this.this$0.skinBessmert.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = 11;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.BessmertBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 9:
                        if (this.this$0.TwoFaceBuy > 0 && this.this$0.skinTwoFace.size() == 1 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = 12;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.TwoFaceBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 10:
                        if (this.this$0.VorBuy > 0 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = 13;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.VorBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 11:
                        if (this.this$0.VampBuy > 0 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = 14;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.VampBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                        break;
                    case 12:
                        if (this.this$0.NingaBuy > 0 && this.this$0.skinShirt.size() <= 1) {
                            VoteCart.prof = 15;
                            this.this$0.game.setScreen(this.this$0.game.cart);
                        } else if (this.this$0.NingaBuy > 0) {
                            this.this$0.WindowRole(this.this$0.Role, true);
                        } else {
                            this.this$0.WindowRole(this.this$0.Role, false);
                        }
                }
            }

            return true;
        }
    }

    public final class QMafiaListner extends InputListener {
        final RoomsScreen this$0;

        public QMafiaListner(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 1;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    public final class QMirnListner extends InputListener {
        final RoomsScreen this$0;

        public QMirnListner(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            VoteCart.prof = 2;
            this.this$0.game.setScreen(this.this$0.game.cart);
            return true;
        }
    }

    public class StartSearchListener extends InputListener {
        final RoomsScreen this$0;

        public StartSearchListener(RoomsScreen var1) {
            this.this$0 = var1;
        }

        public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            try {
                if (!this.this$0.Create.isDisabled()) {
                    String var6 = this.this$0.Create.getText().toString();
                    Mafia var7 = this.this$0.game;
                    if (var6.equals(Mafia.local.get("stop_search"))) {
                        MainMenuScreen.Connect_Class.socket.emit("RemoveSearcher", new Object[0]);
                        this.this$0.Create.setDisabled(true);
                    } else if (this.this$0.game.rooms.updateIcon(this.this$0.game.rooms.Role)) {
                        if (this.this$0.game.rooms.visionOfPaint > 0 && !TableInRoomScreen.getInstance(this.this$0.game).isInParty() && this.this$0.game.rooms.Role != 2) {
                            Image var13 = new Image(this.this$0.game.game.skin, "glasses");
                            var13.setWidth(50.0F);
                            var13.setHeight(33.0F);
                            Mafia var8 = this.this$0.game;
                            MafiaStage var12 = this.this$0.game.rooms.stage;
                            Mafia var9 = this.this$0.game;
                            String var14 = Mafia.local.get("use_vision_of_paint?");
                            FunctionOfWindow var10 = new FunctionOfWindow() {
                                public void acceptAction() {
                                    TableInRoomScreen.getInstance(this$0.game).sendDataToServerToStart(true);
                                }

                                public void rejectAction() {
                                    TableInRoomScreen.getInstance(this$0.game).sendDataToServerToStart(false);
                                }
                            };
                            new WindowDefault("", var8, var12, var14, var10, var13);
                        } else {
                            TableInRoomScreen.getInstance(this$0.game).sendDataToServerToStart(false);
                        }
                    }
                }
            } catch (JSONException var11) {
                ThrowableExtension.printStackTrace(var11);
            }

            return super.touchDown(var1, var2, var3, var4, var5);
        }
    }
}
