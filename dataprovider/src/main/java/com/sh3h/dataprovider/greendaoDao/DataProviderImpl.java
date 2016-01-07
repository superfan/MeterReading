package com.sh3h.dataprovider.greendaoDao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sh3h.dataprovider.IDataProvider;
import com.sh3h.dataprovider.entity.ConditionInfo;
import com.sh3h.dataprovider.entity.GongDan;
import com.sh3h.dataprovider.entity.GongDanCHAOBIAOZT;
import com.sh3h.dataprovider.entity.GongDanWORDS;
import com.sh3h.dataprovider.entity.GongDanYONGHUPZ;
import com.sh3h.dataprovider.greendaoEntity.BIAOKAXX;
import com.sh3h.dataprovider.greendaoEntity.BiaoWuGD;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoBZ;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoGJ;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoInfo;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoJL;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoRW;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoSJ;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoZT;
import com.sh3h.dataprovider.greendaoEntity.ChaoBiaoZTFL;
import com.sh3h.dataprovider.greendaoEntity.CiYuXX;
import com.sh3h.dataprovider.greendaoEntity.DengLuLS;
import com.sh3h.dataprovider.greendaoEntity.DingEJJBL;
import com.sh3h.dataprovider.greendaoEntity.DuoMeiTXX;
import com.sh3h.dataprovider.greendaoEntity.FeiYongZC;
import com.sh3h.dataprovider.greendaoEntity.FeiYongZKL;
import com.sh3h.dataprovider.greendaoEntity.GongGaoXX;
import com.sh3h.dataprovider.greendaoEntity.GuiJi;
import com.sh3h.dataprovider.greendaoEntity.HuanBiaoJL;
import com.sh3h.dataprovider.greendaoEntity.JianHao;
import com.sh3h.dataprovider.greendaoEntity.JianHaoMX;
import com.sh3h.dataprovider.greendaoEntity.JiaoFeiXX;
import com.sh3h.dataprovider.greendaoEntity.MetaInfo;
import com.sh3h.dataprovider.greendaoEntity.QianFeiXX;
import com.sh3h.dataprovider.greendaoEntity.RenwuXX;
import com.sh3h.dataprovider.greendaoEntity.ShuiLiangFTXX;
import com.sh3h.dataprovider.greendaoEntity.UserInfo;
import com.sh3h.dataprovider.greendaoEntity.Users;
import com.sh3h.dataprovider.greendaoEntity.WaiFuGDDetail;
import com.sh3h.dataprovider.greendaoEntity.WaiFuGDMain;
import com.sh3h.dataprovider.greendaoEntity.WordsInfo;
import com.sh3h.dataprovider.greendaoEntity.XinXiBG;
import com.sh3h.dataprovider.greendaoEntity.YanChiBiao;
import com.sh3h.dataprovider.greendaoEntity.YuanGongXX;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurui on 2015/8/3.
 */
public class DataProviderImpl implements
        IDataProvider {

    private SQLiteDatabase db;
    private Context context;

    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static final String YICHAO = "已抄";
    public static final String WEICHAO = "未抄";
    public static final String GUCHAO = "估算";

    private BIAOKAXXDao biaokaxxDao;
    private ChaoBiaoZTDao chaoBiaoZTDao;
    private ChaoBiaoZTFLDao chaoBiaoZTFLDao;
    private DuoMeiTXXDao duoMeiTXXDao;
    private GuiJiDao guiJiDao;
    private NeiFuBZDao neiFuBZDao;
    private ZhuangTaiLXCSDao zhuangTaiLXCSDao;
    private RenwuXXDao renwuXXDao;
    private UsersDao userDao;
    private WaiFuGDDetailDao waiFuGDDetailDao;
    private WaiFuGDMainDao waiFuGDMainDao;
    private YanChiBiaoDao yanChiBiaoDao;
    private JiaoFeiXXDao jiaoFeiXXDao;
    private GongGaoXXDao gongGaoXXDao;
    private YuanGongXXDao yuanGongXXDao;
    private UserInfoDao userInfoDao;
    private QianFeiXXDao qianFeiXXDao;
    private JianHaoMXDao jianhaoMXDao;
    private HuanBiaoJLDao huanBiaoJLDao;
    private ChaoBiaoBZDao chaoBiaoBZDao;
    private ChaoBiaoGJDao chaoBiaoGJDao;
    private ChaoBiaoJLDao chaoBiaoJLDao;
    private ChaoBiaoRWDao chaoBiaoRWDao;
    private ChaoBiaoSJDao chaoBiaoSJDao;
    private CiYuXXDao ciYuXXDao;
    private ReXianGDDao reXianGDDao;
    private WordsInfoDao wordsInfoDao;
    private DingEJJBLDao dingEJJBLDao;
    private FeiYongZCDao feiYongZCDao;
    private JianHaoDao jianHaoDao;
    private FeiYongZKLDao feiYongZKLDao;
    private ShuiLiangFTXXDao shuiLiangFTXXDao;
    private XinXiBGDao xinXiBGDao;
    private DengLuLSDao dengLuLSDao;
    private MetaInfoDao metaInfoDao;
    private BiaoWuGDDao biaoWuDGDao;

//    private GongDanCHAOBIAOZTDao gongDanChaoBiaoDao;
//    private GongDanWORDSDao gongDanWordsDao;
//    private GongDanYONGHUPZDao gongDanYongHuPZDao;

    public DataProviderImpl() {
        db = null;
        context = null;
    }

//    public DataProviderImpl(Context ctx) {
//        context = ctx;
//        db = DaoMaster.getSQLiteDatabase(dataFile.getPath(), ctx);
//        if (db == null) {
//            return;
//        }
//        DaoMaster.createAllTables(db, true);
//        daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
//
//        biaokaxxDao = daoSession.getBIAOKAXXDao();
//        chaoBiaoZTDao = daoSession.getChaoBiaoZTDao();
//        chaoBiaoZTFLDao = daoSession.getChaoBiaoZTFLDao();
//        duoMeiTXXDao = daoSession.getDuoMeiTXXDao();
//        guiJiDao = daoSession.getGuiJiDao();
//        neiFuBZDao = daoSession.getNeiFuBZDao();
//        zhuangTaiLXCSDao = daoSession.getZhuangTaiLXCSDao();
//        renwuXXDao = daoSession.getRenwuXXDao();
//        userDao = daoSession.getUsersDao();
//        waiFuGDDetailDao = daoSession.getWaiFuGDDetailDao();
//        waiFuGDMainDao = daoSession.getWaiFuGDMainDao();
//        yanChiBiaoDao = daoSession.getYanChiBiaoDao();
//        jiaoFeiXXDao = daoSession.getJiaoFeiXXDao();
//        gongGaoXXDao = daoSession.getGongGaoXXDao();
//        yuanGongXXDao = daoSession.getYuanGongXXDao();
//        userInfoDao = daoSession.getUserInfoDao();
//        qianFeiXXDao = daoSession.getQianFeiXXDao();
//        jianhaoMXDao = daoSession.getJianHaoMXDao();
//
//        huanBiaoJLDao = daoSession.getHuanBiaoJLDao();
//        chaoBiaoBZDao = daoSession.getChaoBiaoBZDao();
//        chaoBiaoGJDao = daoSession.getChaoBiaoGJDao();
//        chaoBiaoJLDao = daoSession.getChaoBiaoJLDao();
//        chaoBiaoRWDao = daoSession.getChaoBiaoRWDao();
//        chaoBiaoSJDao = daoSession.getChaoBiaoSJDao();
//        ciYuXXDao = daoSession.getCiYuXXDao();
//        reXianGDDao = daoSession.getReXianGDDao();
//        wordsInfoDao = daoSession.getWordsInfoDao();
//        dingEJJBLDao = daoSession.getDingEJJBLDao();
//        feiYongZCDao = daoSession.getFeiYongZCDao();
//        jianHaoDao = daoSession.getJianHaoDao();
//        feiYongZKLDao = daoSession.getFeiYongZKLDao();
//        shuiLiangFTXXDao = daoSession.getShuiLiangFTXXDao();
//        xinXiBGDao = daoSession.getXinXiBGDao();
//        dengLuLSDao = daoSession.getDengLuLSDao();
//        metaInfoDao = daoSession.getMetaInfoDao();
//        biaoWuDGDao = daoSession.getBiaoWuGDDao();
//    }

    @Override
    public synchronized boolean init(String path, Context context) {
        this.context = context;
        db = DaoMaster.getSQLiteDatabase(path, context);
        if (db == null) {
            return false;
        }
        DaoMaster.createAllTables(db, true);
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        biaokaxxDao = daoSession.getBIAOKAXXDao();
        chaoBiaoZTDao = daoSession.getChaoBiaoZTDao();
        chaoBiaoZTFLDao = daoSession.getChaoBiaoZTFLDao();
        duoMeiTXXDao = daoSession.getDuoMeiTXXDao();
        guiJiDao = daoSession.getGuiJiDao();
        neiFuBZDao = daoSession.getNeiFuBZDao();
        zhuangTaiLXCSDao = daoSession.getZhuangTaiLXCSDao();
        renwuXXDao = daoSession.getRenwuXXDao();
        userDao = daoSession.getUsersDao();
        waiFuGDDetailDao = daoSession.getWaiFuGDDetailDao();
        waiFuGDMainDao = daoSession.getWaiFuGDMainDao();
        yanChiBiaoDao = daoSession.getYanChiBiaoDao();
        jiaoFeiXXDao = daoSession.getJiaoFeiXXDao();
        gongGaoXXDao = daoSession.getGongGaoXXDao();
        yuanGongXXDao = daoSession.getYuanGongXXDao();
        userInfoDao = daoSession.getUserInfoDao();
        qianFeiXXDao = daoSession.getQianFeiXXDao();
        jianhaoMXDao = daoSession.getJianHaoMXDao();
        huanBiaoJLDao = daoSession.getHuanBiaoJLDao();
        chaoBiaoBZDao = daoSession.getChaoBiaoBZDao();
        chaoBiaoGJDao = daoSession.getChaoBiaoGJDao();
        chaoBiaoJLDao = daoSession.getChaoBiaoJLDao();
        chaoBiaoRWDao = daoSession.getChaoBiaoRWDao();
        chaoBiaoSJDao = daoSession.getChaoBiaoSJDao();
        ciYuXXDao = daoSession.getCiYuXXDao();
        reXianGDDao = daoSession.getReXianGDDao();
        wordsInfoDao = daoSession.getWordsInfoDao();
        dingEJJBLDao = daoSession.getDingEJJBLDao();
        feiYongZCDao = daoSession.getFeiYongZCDao();
        jianHaoDao = daoSession.getJianHaoDao();
        feiYongZKLDao = daoSession.getFeiYongZKLDao();
        shuiLiangFTXXDao = daoSession.getShuiLiangFTXXDao();
        xinXiBGDao = daoSession.getXinXiBGDao();
        dengLuLSDao = daoSession.getDengLuLSDao();
        metaInfoDao = daoSession.getMetaInfoDao();
        biaoWuDGDao = daoSession.getBiaoWuGDDao();

//        gongDanChaoBiaoDao = new GongDanCHAOBIAOZTDao();
//        gongDanWordsDao = new GongDanWORDSDao();
//        gongDanYongHuPZDao = new GongDanYONGHUPZDao();

        return true;
    }

    @Override
    public synchronized void destroy() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    @Override
    public synchronized MetaInfo getMetaInfo(String account) {
        return metaInfoDao.get(account);
    }

    @Override
    public synchronized List<ChaoBiaoRW> getChaoBiaoRWList(String account) {
        return chaoBiaoRWDao.get(account);
    }

    @Override
    public synchronized ChaoBiaoRW getChaoBiaoRW(int id) {
        return chaoBiaoRWDao.get(id);
    }

    @Override
    public synchronized ChaoBiaoRW getChaoBiaoRW(String account, int taskId, String ch) {
        return chaoBiaoRWDao.getChaoBiaoRW(account, taskId, ch);
    }

    @Override
    public synchronized List<ChaoBiaoRW> getChaoBiaoRWList(String account, String ids) {
        return chaoBiaoRWDao.getChaoBiaoRWList(account, ids);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getListChaoBiaoSJ(String cH, int sortType) {
        return chaoBiaoSJDao.getList(cH, sortType);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getListChaoBiaoSJ(int taskId, String cH, int sortType, List<String> cids) {
        return chaoBiaoSJDao.getList(taskId, cH, sortType, cids);
    }

    @Override
    public synchronized ChaoBiaoSJ getChaoBiaoSJ(int taskId, String cH, String cId) {
        return chaoBiaoSJDao.get(taskId, cH, cId);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getChaoBiaoSJList(int taskId, String ch, List<String> cids) {
        return chaoBiaoSJDao.get(taskId, ch, cids);
    }

    @Override
    public synchronized ChaoBiaoSJ getNextChaoBiaoSJ(int taskId, String ch, long ceneixh) {
        return chaoBiaoSJDao.getNextChaoBiaoSJ(taskId, ch, ceneixh);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getNextUnfinishedChaoBiaoSJWithCeNeiXH(int renWuBH, String ch) {
        return chaoBiaoSJDao.getNextUnfinishedChaoBiaoSJWithCeNeiXH(renWuBH, ch);
    }

    @Override
    public synchronized ChaoBiaoSJ getPreviousChaoBiaoSJ(int taskId, String ch, long ceneixh) {
        return chaoBiaoSJDao.getPreviousChaoBiaoSJ(taskId, ch, ceneixh);
    }

    @Override
    public synchronized BIAOKAXX getBiaoKaXX(String cId) {
        return this.biaokaxxDao.get(cId);
    }

    @Override
    public synchronized List<ChaoBiaoInfo> getchaoBiaoSJ(int chaoBiaoBZ, String cH, String chaoBiaoY) {
        return chaoBiaoSJDao.getchaoBiaoPieSJ(chaoBiaoBZ, cH, chaoBiaoY);
    }

    @Override
    public synchronized int getBiaoKaCount(String s_ch) {
        return chaoBiaoSJDao.getBiaoKaCount(s_ch);
    }

    @Override
    public synchronized ChaoBiaoSJ getChaoBSJBySCHAndCeNeiPX(String S_CH, Integer I_CeNeiPX) {
        return chaoBiaoSJDao.getChaoBSJBySCHAndCeNeiPX(S_CH, I_CeNeiPX);
    }

    @Override
    public synchronized Map<String, Integer> getChaoBiaoSJCount(String cH, String guSuan, String chaoBiaoY) {

        int sjCount = chaoBiaoSJDao.getChaoBiaoPillarSJ(cH, chaoBiaoY);
        int weiChao = chaoBiaoSJDao.getChaoBiaoPillarWCSJ(cH, chaoBiaoY);
        int guSuanBM = chaoBiaoSJDao.getChaoBiaoPillarYCSJ(cH, guSuan,
                chaoBiaoY);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(GUCHAO, guSuanBM);
        map.put(WEICHAO, weiChao);
        map.put(YICHAO, sjCount);

        return map;
    }

    @Override
    public synchronized ChaoBiaoSJ getUnWorkChaoBiaoSJ(String CH) {
        return chaoBiaoSJDao.getFirstUnWorkChaoBiaoSJ(CH);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getSelectChaoBiaoSJ(String str, String cH) {
        return chaoBiaoSJDao.getSelectChaoBiaoSJ(str, cH);
    }

//    @Override
//    public synchronized boolean updateChaobiaoSJ(String S_CID, int I_ZhuangTaiBM, String S_ZhuangTaiMC,
//                                    int I_BenCiCM, int I_ChaoJianSL, double N_JE, String S_CH,
//                                    int I_LiangGaoLDYYBM, String S_ChaoBiaoBeiZhu, double x1,
//                                    double y1, int chaoBiaoBiaoZhi, String jieTiTS) {
//        return chaoBiaoSJDao.updateChaobiaoSJ(S_CID, I_ZhuangTaiBM,
//                S_ZhuangTaiMC, I_BenCiCM, I_ChaoJianSL, N_JE,
//                S_CH, I_LiangGaoLDYYBM, S_ChaoBiaoBeiZhu,
//                x1, y1, chaoBiaoBiaoZhi, jieTiTS);
//    }

    @Override
    public synchronized List<JianHaoMX> getJianHaoMXByJH(String S_JH) {
        return jianhaoMXDao.getJianHaoMXByJH(S_JH);
    }

    @Override
    public synchronized ChaoBiaoZT getChaoBiaoZT(int i_chaobiaoztbm) {
        return null;
    }

    @Override
    public synchronized List<ChaoBiaoZT> getAllChaobiaozt() {
        return chaoBiaoZTDao.getAllChaobiaozt();
    }

    @Override
    public synchronized List<JiaoFeiXX> getListJiaoFeiXX(String cId) {
        return jiaoFeiXXDao.getList(cId);
    }

    @Override
    public synchronized List<QianFeiXX> getListQianFeiXX(String cId) {
        return qianFeiXXDao.getList(cId);
    }

    @Override
    public synchronized List<ChaoBiaoJL> getListChaoBiaoJL(String cId) {
        return chaoBiaoJLDao.getList(cId);
    }

    @Override
    public synchronized List<ChaoBiaoJL> getAllListChaoBiaoJL() {
        return chaoBiaoJLDao.getAllList();
    }

    @Override
    public synchronized List<ChaoBiaoZTFL> getAllChaobiaoZTFL() {
        return this.chaoBiaoZTFLDao.getAllChaobiaoztfl();
    }

    @Override
    public synchronized List<ChaoBiaoZT> getChaoBiaoZTFL(int zhuangtaiFLBM) {
        return null;
    }

    @Override
    public synchronized List<ChaoBiaoZT> getZhuangTaiBMList(String zhuangTaiBM) {
        return this.chaoBiaoZTDao.getAllChaobiaozt(zhuangTaiBM);
    }

    @Override
    public synchronized void deleteShuiLiangFTXX(String CIDAll) {
        shuiLiangFTXXDao.deleteShuiLiangFTXX(CIDAll);
    }

    @Override
    public synchronized boolean insertShuiLiangFTXX(ShuiLiangFTXX shuiLiangFTXX) {
        return shuiLiangFTXXDao.insertShuiLiangFTXX(shuiLiangFTXX);
    }

    @Override
    public synchronized boolean updateShuiLiangFTXX(ShuiLiangFTXX shuiLiangFTXX) {
        return shuiLiangFTXXDao.updateShuiLiangFTXX(shuiLiangFTXX);
    }

    @Override
    public synchronized void insertOrUpdateShuiLiangFTXXList(List<ShuiLiangFTXX> shuiLiangFTXXList) {
        shuiLiangFTXXDao.insertOrUpdateShuiLiangFTXXList(shuiLiangFTXXList);
    }

    @Override
    public synchronized List<ShuiLiangFTXX> getShuiLiangFenTXX(String s_cid) {
        return shuiLiangFTXXDao.getShuiLiangFenTXX(s_cid);
    }

    @Override
    public synchronized List<String> getCH() {
        return chaoBiaoRWDao.getCH();
    }

    @Override
    public synchronized boolean insertDuoMeiTXX(DuoMeiTXX duoMeiTXX) {
        return duoMeiTXXDao.insertDuoMeiTXX(duoMeiTXX);
    }

    @Override
    public synchronized boolean updateNJE(int taskId, String cH, String S_CID, double N_JE) {
        return chaoBiaoSJDao.updateNJE(taskId, cH, S_CID, N_JE);
    }

    @Override
    public synchronized List<DuoMeiTXX> getDuoMeiTXXList(int chaoBiaoID, String CID) {
        return duoMeiTXXDao.getDuoMeiTXXList(chaoBiaoID, CID);
    }

    @Override
    public synchronized List<DuoMeiTXX> getNotUploadedDuoMeiTXXList(String account, int renwubh, String ch) {
        return duoMeiTXXDao.getNotUploadedDuoMeiTXXList(account, renwubh, ch);
    }

    @Override
    public synchronized boolean deleteDuoMeiTXX(String wenJianMC) {
        return duoMeiTXXDao.deleteDuoMeiTXX(wenJianMC);
    }

    @Override
    public synchronized List<JianHao> getJianHaoList() {
        return null;
    }

    @Override
    public synchronized JianHao getJianHao(String strZhongLei) {
        return null;
    }

    @Override
    public synchronized List<BIAOKAXX> QueryBiaoKaxxsWhere(String swhere, int GuBiaoLXCS, int LiangGaoLDLXCS) {
        return biaokaxxDao.QueryBiaoKaxxsWhere(swhere, GuBiaoLXCS,
                LiangGaoLDLXCS);
    }

    @Override
    public synchronized List<BIAOKAXX> QueryBiaoKaxxsWhere(String key, String ChaoBiaoRWCHAll) {
        return biaokaxxDao.QueryBiaoKaxxsWhere(key, ChaoBiaoRWCHAll);
    }

    @Override
    public synchronized List<CiYuXX> getLiangGaoYY() {
        return ciYuXXDao.getLiangGaoYY();
    }

    @Override
    public synchronized List<CiYuXX> getLiangDiYY() {
        return ciYuXXDao.getLiangDiYY();
    }

    @Override
    public synchronized boolean authInterface(String account) {
        return metaInfoDao.authenticationInterface(account);
    }

    @Override
    public synchronized double getDingEJiaGeByCIDAndJH(String S_CID, String S_JH) {
        return jianhaoMXDao.getDingEJiaGeByCIDAndJH(S_CID, S_JH);
    }

    @Override
    public synchronized List<DingEJJBL> getAllDingEJJBL() {
        return dingEJJBLDao.getAllDingEJJBL();
    }

    @Override
    public synchronized boolean existCiYuXX(int id) {
        return ciYuXXDao.existCiYuXX(id);
    }

    @Override
    public synchronized List<CiYuXX> getCiYuXX(int belongid) {
        return ciYuXXDao.getCiYuXX(belongid);
    }

    @Override
    public synchronized boolean deleteCiYu() {
        return ciYuXXDao.delete();
    }

    @Override
    public synchronized boolean deleteCiYu(String code) {
        return ciYuXXDao.delete(code);
    }

    @Override
    public synchronized void insertCiYu(CiYuXX ciyuXX) {
        ciYuXXDao.insertCiyuXX(ciyuXX);
    }

    @Override
    public synchronized YuanGongXX getYuanGongXX(String account) {
        return yuanGongXXDao.get(account);
    }

    @Override
    public synchronized int auth(String pwd, String account) {
        return dengLuLSDao.auth(pwd, account);
    }

    @Override
    public synchronized boolean updateDengLuLS(DengLuLS dengLuLS) {
        return dengLuLSDao.updateDengLuLS(dengLuLS);
    }

    @Override
    public synchronized int updateYHxx(String s_CID, String s_LianXiDH, String s_LIANXISJ, String s_JianHao, String s_BEIZHU) {
        XinXiBG xinxi = new XinXiBG();
        xinxi.setS_CID(s_CID);
        xinxi.setS_LianXiDH(s_LianXiDH);
        xinxi.setS_LIANXISJ(s_LIANXISJ);
        xinxi.setS_JianHao(s_JianHao);
        xinxi.setS_BEIZHU(s_BEIZHU);

        return xinXiBGDao.InsertXinXiBG(xinxi);
    }

    @Override
    public synchronized List<HuanBiaoJL> getHuanBiaoJLList(String cId) {
        return huanBiaoJLDao.getList(cId);
    }

    @Override
    public synchronized boolean clearHuanBiaoJL(String cId) {
        return huanBiaoJLDao.clear(cId);
    }

    @Override
    public synchronized boolean insertHuanBiaoJL(HuanBiaoJL huanbiaojl) {
        return huanBiaoJLDao.insertData(huanbiaojl);
    }

    @Override
    public synchronized boolean updateBiaoKaXX(BIAOKAXX biaoKaXX) {
        return biaokaxxDao.updateSingle(biaoKaXX);
    }

    @Override
    public synchronized boolean clearChaoBiaoJL(String cId) {

        return chaoBiaoJLDao.clear(cId);
    }

    @Override
    public synchronized boolean insertChaoBiaoJL(ChaoBiaoJL chaoBiaoJL) {
        return chaoBiaoJLDao.insertData(chaoBiaoJL);
    }

    @Override
    public synchronized boolean clearJiaoFeiXX(String cId) {
        return jiaoFeiXXDao.clear(cId);
    }

    @Override
    public synchronized boolean insertJiaoFeiXX(JiaoFeiXX jiaoFeiXX) {
        return jiaoFeiXXDao.insertData(jiaoFeiXX);
    }

    @Override
    public synchronized boolean clearQianFeiXX(String cId) {
        return qianFeiXXDao.clear(cId);
    }

    @Override
    public synchronized boolean insertQianFeiXX(QianFeiXX qianFeiXX) {
        return qianFeiXXDao.insertData(qianFeiXX);
    }

    @Override
    public synchronized List<CiYuXX> getCiYuXXlist(int belongid) {
        return null;
    }

    @Override
    public synchronized List<GongGaoXX> getGongGaoXXList() {
        return gongGaoXXDao.getGongGaoXXList();
    }

    @Override
    public synchronized GongGaoXX getGongGaoXX(int gongGaoBH) {
        return gongGaoXXDao.getGongGaoXX(gongGaoBH);
    }

    @Override
    public synchronized boolean insertGongGaoXX(GongGaoXX gongGaoXX) {
        return gongGaoXXDao.insertGongGaoXX(gongGaoXX);
    }

    @Override
    public synchronized DengLuLS getDengLuLS(String account) {
        return dengLuLSDao.getDengLuLS(account);
    }

    @Override
    public synchronized void insertChaoBiaoZT(ChaoBiaoZT chaoBiaoZT) {
        chaoBiaoZTDao.insertChaoBiaoZT(chaoBiaoZT);
    }

    @Override
    public synchronized void deleteChaoBiaoZT() {
        chaoBiaoZTDao.deleteChaoBiaoZT();
    }

    @Override
    public synchronized boolean existChaoBiaoZT(int zhuangTaiBM) {
        return false;
    }

    @Override
    public synchronized boolean existChaoBiaoZTFL(int fenLeiBM) {
        return chaoBiaoZTFLDao.existChaoBiaoZTFL(fenLeiBM);
    }

    @Override
    public synchronized void deleteChaoBiaoZTFL() {
        chaoBiaoZTFLDao.deleteChaoBiaoZTFL();
    }

    @Override
    public synchronized void insertChaoBiaoZTFL(ChaoBiaoZTFL chaoBiaoZTFL) {
        chaoBiaoZTFLDao.insertChaoBiaoZTFL(chaoBiaoZTFL);
    }

    @Override
    public synchronized boolean existDingEJJBL(int id) {
        return dingEJJBLDao.existDingEJJBL(id);
    }

    @Override
    public synchronized void deleteDingEJJBL() {
        dingEJJBLDao.deleteDingEJJBL();
    }

    @Override
    public synchronized void insertDingEJJBL(DingEJJBL dingEJJBL) {
        dingEJJBLDao.insertDingEJJBL(dingEJJBL);
    }

    @Override
    public synchronized boolean existFeiYongZC(int id) {
        return feiYongZCDao.existFeiYongZC(id);
    }

    @Override
    public synchronized void deleteFeiYongZC() {
        feiYongZCDao.deleteFeiYongZC();
    }

    @Override
    public synchronized void insertFeiYongZC(FeiYongZC feiYongZC) {
        feiYongZCDao.insertFeiYongZC(feiYongZC);
    }

    @Override
    public synchronized boolean existJianhao(int id) {
        return jianHaoDao.existJianhao(id);
    }

    @Override
    public synchronized void deleteJianHao() {
        jianHaoDao.deleteJianHao();
    }

    @Override
    public synchronized void insertJianHao(JianHao Jianhao) {
        jianHaoDao.insertJianHao(Jianhao);
    }

    @Override
    public synchronized boolean existJianHaoMX(int id) {
        return jianhaoMXDao.existJianHaoMX(id);
    }

    @Override
    public synchronized void deleteJianHaoMX() {
        jianhaoMXDao.deleteJianHaoMX();
    }

    @Override
    public synchronized void insertJianHaoMX(JianHaoMX jianHaoMX) {
        jianhaoMXDao.insertJianHaoMX(jianHaoMX);
    }

    @Override
    public synchronized boolean insertBiaoKaXX(BIAOKAXX biaoKaXX) {
        return biaokaxxDao.insertData(biaoKaXX);
    }

    @Override
    public synchronized void insertOrUpdateBiaoKaXXList(List<BIAOKAXX> biaoKaXXList) {
        biaokaxxDao.insertOrUpdate(biaoKaXXList);
    }

    @Override
    public synchronized long getGongGaoFaBuSJ() {
        return gongGaoXXDao.getGongGaoSJ();
    }

    @Override
    public synchronized int getGongGaoXXUnreadCount() {
        return gongGaoXXDao.getGongGaoXXUnreadCount();
    }

    @Override
    public synchronized void updateCongGaoXXYD(int gongGaoBH) {
        gongGaoXXDao.updateCongGaoXXYD(gongGaoBH);
    }

    @Override
    public synchronized double getFeiYongZKL(String S_CID, String S_JH, int I_FeiYongDLBH) {
        return feiYongZKLDao.getFeiYongZKL(S_CID, S_JH, I_FeiYongDLBH);
    }

    @Override
    public synchronized void insertChaoBiaoSJ(ChaoBiaoSJ chaoBiaoSJ) {
        chaoBiaoSJDao.insertChaoBiaoSJ(chaoBiaoSJ);
    }

    @Override
    public synchronized void insertChaoBiaoSJList(List<ChaoBiaoSJ> chaoBiaoSJList) {
        chaoBiaoSJDao.insertChaoBiaoSJList(chaoBiaoSJList);
    }

    @Override
    public synchronized void updateChaoBiaoSJ(ChaoBiaoSJ chaoBiaoSJ) {
        chaoBiaoSJDao.updateChaoBiaoSJ(chaoBiaoSJ);
    }

    @Override
    public synchronized void deleteChaoBiaoSJ(int renWuBH, String chaoBiaoYuan) {
        chaoBiaoSJDao.deleteChaoBiaoSJ(renWuBH, chaoBiaoYuan);
    }

    @Override
    public synchronized void deleteChaoBiaoSJ(String account, int renWuBH, String ch) {
        chaoBiaoSJDao.deleteChaoBiaoSJ(account, renWuBH, ch);
    }

    @Override
    public synchronized boolean clearChaoBiaoRW(String chaoBiaoYBH, int renWuBH) {
        return chaoBiaoRWDao.clear(chaoBiaoYBH, renWuBH);
    }

    @Override
    public synchronized boolean updateChaoBiaoRW(ChaoBiaoRW chaoBiaoRW) {
        return chaoBiaoRWDao.updateChaoBiaoRW(chaoBiaoRW);
    }

    @Override
    public synchronized boolean updateChaoBiaoRW(String account, String ch, int renwuBH, int finishednum,int flag) {
        return chaoBiaoRWDao.updateChaoBiaoRW(account, ch, renwuBH, finishednum, flag);
    }

    @Override
    public synchronized boolean insertChaoBiaoRW(ChaoBiaoRW chaoBiaoRW) {
        return chaoBiaoRWDao.insertData(chaoBiaoRW);
    }

    @Override
    public synchronized void delectChaoBiaoRW(String chaoBiaoYBH, String renWuBHAll) {
        chaoBiaoRWDao.delectChaoBiaoRW(chaoBiaoYBH, renWuBHAll);
    }

    @Override
    public synchronized String selectNonentityChaoBiaoRW(String chaoBiaoYBH, String renWuBHAll) {
        return chaoBiaoRWDao.selectNonentityChaoBiaoRW(chaoBiaoYBH, renWuBHAll);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getChaoBiaoSJ(int chaoBiaoBZ, int shangChuanBZ, String chaobiaoRWAll) {
        return chaoBiaoSJDao.getChaoBiaoSJ(chaoBiaoBZ, shangChuanBZ, chaobiaoRWAll);
    }

    @Override
    public synchronized void delectChaoBiaoSJ(String renWuBHAll, String chaoBiaoYBH) {
        chaoBiaoSJDao.delectChaoBiaoSJ(renWuBHAll, chaoBiaoYBH);
    }

    @Override
    public synchronized String getChaoBiaoRenWuBH(String Account) {
        return null;
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getChaoBiaoSJRenWuBH(int chaoBiaoBZ, int shangChuanBZ, int renWuBH, int flag) {
        return chaoBiaoSJDao.getChaoBiaoSJRenWuBH(chaoBiaoBZ,
                shangChuanBZ, renWuBH, flag);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getChaoBiaoSJCBY(String chaoBiaoY,
                                                          int renWuBH,
                                                          String ch,
                                                          int chaoBiaoBZ,
                                                          int shangChuanBZ) {
        return chaoBiaoSJDao.getChaoBiaoSJCBY(chaoBiaoY, renWuBH, ch, chaoBiaoBZ, shangChuanBZ);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getAllChaoBiaoSJCBY(String chaoBiaoY, int renWuBH, String ch, int chaoBiaoBZ) {

        return chaoBiaoSJDao.getAllChaoBiaoSJCBY(chaoBiaoY, renWuBH, ch, chaoBiaoBZ);
    }

    @Override
    public synchronized List<Integer> getCeNetXH(String ch, String account) {
        return chaoBiaoSJDao.getCeNetXH(ch, account);
    }

    @Override
    public synchronized void UpdateShangChuanBIaoZhi(int taskId, String cH, String cid, int ShangChuanBZ) {
        chaoBiaoSJDao.UpdateShangChuanBIaoZhi(taskId, cH, cid, ShangChuanBZ);
    }

    @Override
    public synchronized boolean delectGongGaoXX(int gongGaoBH) {
        return gongGaoXXDao.delectGongGaoXX(gongGaoBH);
    }

    @Override
    public synchronized List<String> getChaoBiaoSJCID(String ChaoBiaoYBH, String renWuBHAll) {
        return null;
    }

    @Override
    public synchronized void delectBiaoKaXX(String cidAll) {
        biaokaxxDao.delectBiaoKaXX(cidAll);
    }

    @Override
    public synchronized void delectQianFeiXX(String cidAll) {
        qianFeiXXDao.delectQianFeiXX(cidAll);
    }

    @Override
    public synchronized void delectJiaoFeiXX(String cidAll) {
        jiaoFeiXXDao.delectJiaoFeiXX(cidAll);
    }

    @Override
    public synchronized void delectHuanBiaoJL(String cidAll) {
        delectHuanBiaoJL(cidAll);
    }

    @Override
    public synchronized void delectchaoBiaoJL(String cidAll) {

        chaoBiaoJLDao.delectChaoBiaoJL(cidAll);
    }

    @Override
    public synchronized boolean insertFeiYongZKL(FeiYongZKL feiYongZKL) {
        return feiYongZKLDao.insertFeiYongZKL(feiYongZKL);
    }

    @Override
    public synchronized void insertFeiYongZKLList(List<FeiYongZKL> feiYongZKLList) {
        feiYongZKLDao.insertFeiYongZKLList(feiYongZKLList);
    }

    @Override
    public synchronized void delectFeiYongZKL(String cidAll) {
        feiYongZKLDao.delectFeiYongZKL(cidAll);
    }

    @Override
    public synchronized void clearFeiYongZKL(String S_CID, String jianHao, int feiYongDLBH) {
        feiYongZKLDao.clearFeiYongZKL(S_CID, jianHao, feiYongDLBH);
    }

    @Override
    public synchronized int getBiaoKaXXCount(String S_CH) {
        return biaokaxxDao.getBiaoKaCount(S_CH);
    }

    @Override
    public synchronized FeiYongZKL getFeiYongZKL(String S_CID, int I_FeiYongDLBH, String S_JH) {
        return feiYongZKLDao.getFeiYongZKL(S_CID, I_FeiYongDLBH, S_JH);
    }

    @Override
    public synchronized List<BiaoWuGD> getBiaoWuGDList(String caoZuoR) {
        return biaoWuDGDao.getBiaoWuGDList(caoZuoR);
    }

    @Override
    public synchronized void deleteBiaoWuGD() {
        biaoWuDGDao.deleteBiaoWuGD();
    }

    @Override
    public synchronized void deleteBiaoWuGDByBH(int renwubh) {
        biaoWuDGDao.deleteBiaoWuGDByBH(renwubh);
    }

    @Override
    public synchronized void insertBiaoWuGD(BiaoWuGD gd) {
        biaoWuDGDao.insertBiaoWuGD(gd);
    }

    @Override
    public synchronized BiaoWuGD getBiaoWuGD(int renWuBH) {
        return biaoWuDGDao.getBiaoWuGD(renWuBH);
    }

    @Override
    public synchronized boolean insertYanChiBiao(YanChiBiao yanChiBiao) {
        return yanChiBiaoDao.insertData(yanChiBiao);
    }

    @Override
    public synchronized List<YanChiBiao> getYanChiBiaoList(String chaoBiaoYId, int yanChiLX, int sortType) {
        return yanChiBiaoDao.getList(chaoBiaoYId, yanChiLX, sortType);
    }

    @Override
    public synchronized void deleteRenWuXX(String account) {
        renwuXXDao.deleteRenWuXX(account);
    }

    @Override
    public synchronized void deleteRenWuXXByBH(int renwubh) {
        renwuXXDao.deleteRenWuXXByBH(renwubh);
    }

    @Override

    public synchronized void deleteNotExistBiaoWuGD(String account, String AllRenWuBH) {
        biaoWuDGDao.deleteNotExistBiaoWuGD(account, AllRenWuBH);
    }

    @Override
    public synchronized void insertRenWuXX(RenwuXX rw) {

        renwuXXDao.insertRenWuXX(rw);
    }

    @Override
    public synchronized List<BiaoWuGD> getWeiShangChuanBiaoWuGD(String account) {
        return biaoWuDGDao.getWeiShangChuanBiaoWuGD(account);
    }

    @Override
    public synchronized void UpdateBiaoWuGD(BiaoWuGD gd) {
        biaoWuDGDao.insertAndUpdateBiaoWuGD(gd);
    }

    @Override
    public synchronized void updateBiaoWuShangChuanZT(String account, BiaoWuGD gd) {
        biaoWuDGDao.updateShangChuanZT(account, gd);
    }

    @Override
    public synchronized boolean updateBiaoWuGDDate(BiaoWuGD gd) {
        return biaoWuDGDao.updateBiaoWuGDDate(gd);
    }

    @Override
    public synchronized String getAllRenWuXXRenWuBH(String account) {
        return renwuXXDao.getAllRenWuXXRenWuBH(account);
    }

    @Override
    public synchronized String getAllRenWuXXYanChiBH(String account) {
        return renwuXXDao.getAllRenWuXXYanChiBH(account);
    }

    @Override
    public synchronized String selectNonentityBiaoWuGDBH(String accoount, String renWuBHAll) {
        return biaoWuDGDao.selectNonentityBiaoWuGDBH(accoount, renWuBHAll);
    }

    @Override
    public synchronized void deleteNotExistYanChiXX(String account, String AllYanChiBH) {
        yanChiBiaoDao.deleteNotExistYanChiXX(account, AllYanChiBH);
    }

    @Override
    public synchronized String selectNonentityYanChiBH(String accoount, String yanChiBHAll) {
        return yanChiBiaoDao.selectNonentityYanChiBH(accoount, yanChiBHAll);
    }

    @Override
    public synchronized int getBiaoWuGDCount(String account) {
        return biaoWuDGDao.getBiaoWuGDCount(account);
    }

    @Override
    public synchronized void updateImgPath(int renWuBH, String imgPath) {
        biaoWuDGDao.updateImgPath(renWuBH, imgPath);
    }

    @Override
    public synchronized String getBiaoWuImgName(int renWuBH) {
        return biaoWuDGDao.getBiaoWuImgName(renWuBH);
    }

    @Override
    public synchronized void updateSignaturePath(int renWuBH, String signaturePath) {
        biaoWuDGDao.updateSignaturePath(renWuBH, signaturePath);
    }

    @Override
    public synchronized List<BiaoWuGD> getBiaoWuGDWeiChaoList(String account) {
        return biaoWuDGDao.getBiaoWuGDWeiChaoList(account);
    }

    @Override
    public synchronized boolean updateYanChiSJ(String S_CID, int I_ZhuangTaiBM,
                                               String S_ZhuangTaiMC, int I_BenCiCM, int I_ChaoJianSL,
                                               double N_JE, String S_CH, int I_LiangGaoLDYYBM,
                                               String S_ChaoBiaoBeiZhu, int chaoBiaoBiaoZhi, String jieTiTS) {
        return yanChiBiaoDao.updateYanChiSJs(S_CID, I_ZhuangTaiBM,
                S_ZhuangTaiMC, I_BenCiCM, I_ChaoJianSL, N_JE, S_CH,
                I_LiangGaoLDYYBM, S_ChaoBiaoBeiZhu, chaoBiaoBiaoZhi, jieTiTS);
    }

    @Override
    public synchronized YanChiBiao getYanChiBiaoXX(String S_CID) {
        return yanChiBiaoDao.get(S_CID);
    }

    @Override
    public synchronized String getBiaoKaXXCIDS(String CIDS) {
        return biaokaxxDao.getBiaoKaXXCIDS(CIDS);
    }

    @Override
    public synchronized List<String> getBiaoKaXXCIDS(String str, String s_ch) {
        return biaokaxxDao.getBiaoKaXXCIDS(str, s_ch);
    }

    @Override
    public synchronized boolean updateYanChiBZ(String S_CID, int yanChiLX, String S_CH, String chaobiaobeizhu) {
        return chaoBiaoSJDao.updateYanChiBZ(S_CID, yanChiLX, S_CH,
                chaobiaobeizhu);
    }

    @Override
    public synchronized boolean updateYanChiShangChuanBZ(String S_CID, int shangchuanBZ) {
        return yanChiBiaoDao.updateYanChiShangChuanBZ(S_CID, shangchuanBZ);
    }

    @Override
    public synchronized boolean updateYanChiSJ(YanChiBiao yanChiBiao) {
        return yanChiBiaoDao.updateYanChiSJ(yanChiBiao);
    }

    @Override
    public synchronized List<YanChiBiao> getWeiShangChuanYanChiBiaoList(String account, int type) {
        return yanChiBiaoDao.getWeiShangChuanYanChiBiaoList(account, type);
    }

    @Override
    public synchronized YanChiBiao getYanChiByCHAndCeNeiPX(String S_CH, Integer I_CeNeiPX) {
        return yanChiBiaoDao.getYanChiByCHAndCeNeiPX(S_CH, I_CeNeiPX);
    }

    @Override
    public synchronized boolean insertWaiFuGDMain(WaiFuGDMain waiFuGDMain) {
        return waiFuGDMainDao.insertData(waiFuGDMain);
    }

    @Override
    public synchronized List<WaiFuGDMain> getWaiFuGDMainList(String account) {
        return waiFuGDMainDao.getWaiFuGDMainList(account);
    }

    @Override
    public synchronized WaiFuGDMain getWaiFuGDMain(int renWuBH) {
        return waiFuGDMainDao.getWaiFuGDMain(renWuBH);
    }

    @Override
    public synchronized String getAllRenWuXXWaiFuGDBH(String account) {
        return renwuXXDao.getAllRenWuXXWaiFuGDBH(account);
    }

    @Override
    public synchronized void deleteNotExistWaiFuGD(String account, String AllRenWuBH) {
        waiFuGDMainDao.deleteNotExistWaiFuGD(account, AllRenWuBH);
    }

    @Override
    public synchronized String selectNonentityWaiFuGDBH(String accoount, String renWuBHAll) {
        return waiFuGDMainDao.selectNonentityWaiFuGDBH(accoount, renWuBHAll);
    }

    @Override
    public synchronized List<WaiFuGDMain> getWeiShangChuanWaiFuGDMainList(String account) {
        return waiFuGDMainDao.getWeiShangChuanWaiFuGDMainList(account);
    }

    @Override
    public synchronized List<WaiFuGDDetail> getupdateWaiFuGDDetailList(String renwuBHs) {
        return null;
    }

    @Override
    public synchronized void deleteWaiFuGDDetailByBH(int renwubh) {
        waiFuGDDetailDao.deleteWaiFuGDDetailByBH(renwubh);
    }

    @Override
    public synchronized int getWeiShangChuanYanChiCount(String account) {
        return yanChiBiaoDao.getWeiShangChuanYanChiCount(account);
    }

    @Override
    public synchronized int getWeiShangChuanWaiFuGDCount(String account) {
        return waiFuGDMainDao.getWeiShangChuanWaiFuGDCount(account);
    }

    @Override
    public synchronized List<WaiFuGDMain> getWaiFuGDMainWeiWanChengList(String account) {
        return waiFuGDMainDao.getWaiFuGDMainWeiWanChengList(account);
    }

    @Override
    public synchronized void insertUsers(Users user) {
        userDao.insertUsers(user);
    }

    @Override
    public synchronized List<Users> getUserList(String account, String station, int type) {
        return userDao.getUserList(account, station, type);
    }

    @Override
    public synchronized void deleteUsers(String account, int type) {
        userDao.deleteUsers(account, type);
    }

    @Override
    public synchronized boolean updateWaiFuGDMain(int renWuBH, WaiFuGDMain waiFuGDMain, int type) {
        return waiFuGDMainDao.updateWaiFuGDMain(renWuBH, waiFuGDMain, type);
    }

    @Override
    public synchronized void deleteWaiFuGDMainByBH(int renwubh) {
        waiFuGDMainDao.deleteWaiFuGDMainByBH(renwubh);
    }

    @Override
    public synchronized void updateWaiFuMainShangChuanZT(String account, WaiFuGDMain wfm) {
        waiFuGDMainDao.updateWaiFuMainShangChuanZT(account, wfm);
    }

    @Override
    public synchronized boolean insertWaiFuGDDetailData(WaiFuGDDetail waiFuGDDetail) {
        return waiFuGDDetailDao.insertData(waiFuGDDetail);
    }

    @Override
    public synchronized List<WaiFuGDDetail> getWaiFuGDDetailList(int renwuBH, boolean isAll) {
        return waiFuGDDetailDao.getWaiFuGDDetailList(renwuBH, isAll);
    }

    @Override
    public synchronized void deleteNotExistWaiFuGDDetail(String account, String AllRenWuBH) {
        waiFuGDDetailDao.deleteNotExistWaiFuGDDetail(account, AllRenWuBH);
    }

    @Override
    public synchronized void deleteWaiFuGDDetail(String account, int renWuBH) {
        waiFuGDDetailDao.deleteWaiFuGDDetail(account, renWuBH);
    }

    @Override
    public synchronized boolean updateYuanChuanBZZHC(int renWubh, String cid, String fuChaJG, int tiaoJianSL) {
        return waiFuGDDetailDao.updateYuanChuanBZZHC(renWubh, cid, fuChaJG,
                tiaoJianSL);
    }

    @Override
    public synchronized void updateBiaoWuGDChaoBiaoBZ(String account, int renWuBH) {
        biaoWuDGDao.updateBiaoWuGDChaoBiaoBZ(account, renWuBH);
    }

    @Override
    public synchronized boolean updateYingCangBZ(int renWubh, String cid) {
        return waiFuGDDetailDao.updateYingCangBZ(renWubh, cid);
    }

    @Override
    public synchronized String getWaiFuMainImgName(int renWuBH) {
        return waiFuGDMainDao.getWaiFuMainImgName(renWuBH);
    }

    @Override
    public synchronized void updateImgPathToWaiFuMain(int renWuBH, String imgPath) {
        waiFuGDMainDao.updateImgPathToWaiFuMain(renWuBH, imgPath);
    }

    @Override
    public synchronized void updateSignaturePathToWaiFuMain(int renWuBH, String signaturePath) {
        waiFuGDMainDao.updateSignaturePathToWaiFuMain(renWuBH, signaturePath);
    }

    @Override
    public synchronized void UpdateWaiFuMainGD(WaiFuGDMain gd) {
        waiFuGDMainDao.insertAndUpdateWaiFuMainGD(gd);
    }

    @Override
    public synchronized void deleteWaiFuGDDetail_one(String account, int renWuBH, String CID) {
        waiFuGDDetailDao.deleteWaiFuGDDetail_one(account, renWuBH, CID);
    }

    @Override
    public synchronized WaiFuGDDetail getWaiFuGDDetail(int renwuBH, String CID) {
        return waiFuGDDetailDao.getWaiFuGDDetail(renwuBH, CID);
    }

    @Override
    public synchronized int getWeiWanChengYanChiCount(String account, int yanChiLX) {
        return yanChiBiaoDao.getWeiWanChengYanChiCount(account, yanChiLX);
    }

    @Override
    public synchronized int getWeiWanChengYanChiCount(String account) {
        return yanChiBiaoDao.getWeiWanChengYanChiCount(account);
    }

    @Override
    public synchronized int getWeiWanChengWFGDCount(String account) {
        return waiFuGDMainDao.getWeiWanChengWFGDCount(account);
    }

    @Override
    public synchronized int getWeiWanChengBWGDCount(String account) {
        return biaoWuDGDao.getWeiWanChengBWGDCount(account);
    }

    @Override
    public synchronized boolean insertGuiJiData(List<GuiJi> guiJiList) {
        return guiJiDao.insertGuiJiData(guiJiList);
    }

    @Override
    public synchronized void deleteGuiJiData() {
        guiJiDao.deleteGuiJiData();
    }

    @Override
    public synchronized List<GuiJi> getGuiJiData(String ch) {
        return guiJiDao.getGuiJiData(ch);
    }

    @Override
    public synchronized int Login(String mima, String account) {
        return userInfoDao.Login(mima, account);
    }

    @Override
    public synchronized UserInfo getUserInfo(String account) {
        return userInfoDao.getUserInfo(account);
    }

    @Override
    public synchronized List<BIAOKAXX> getBiaoKaXXList(String ch) {
        return biaokaxxDao.getBiaoKaXXList(ch);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getNextChaoBiaoSJList(String ch) {
        return chaoBiaoSJDao.getNextChaoBiaoSJList(ch);
    }

    @Override
    public synchronized YanChiBiao getNextYanChiCB(String account, long ceneipx) {
        return yanChiBiaoDao.getNextYanChiCB(account, ceneipx);
    }

    @Override
    public synchronized YanChiBiao getPreviousYanChiCB(String account, long ceneipx) {
        return yanChiBiaoDao.getPreviousYanChiCB(account, ceneipx);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getLiangGaoLiangDiChaoBiaoSJ(String account, int loadType) {
        return chaoBiaoSJDao.getLiangGaoLiangDiChaoBiaoSJ(account, loadType);
    }

    @Override
    public synchronized List<BIAOKAXX> getBiaoKaXX() {
        return biaokaxxDao.getBiaoKaXX();
    }

    @Override
    public synchronized boolean insertChaoBiaoGJ(ChaoBiaoGJ chaoBiaoGJ) {
        return chaoBiaoGJDao.insertChaoBiaoGJ(chaoBiaoGJ);
    }

    @Override
    public synchronized ChaoBiaoGJ getChaoBiaoGJ(String ch, String cid, int type) {
        return chaoBiaoGJDao.getChaoBiaoGJ(ch, cid, type);
    }

    @Override
    public synchronized List<ChaoBiaoGJ> getChaoBiaoGJList(String ch, int type) {
        return chaoBiaoGJDao.getChaoBiaoGJList(ch, type);
    }

    @Override
    public synchronized List<ChaoBiaoGJ> getChaoBiaoGJList(String account) {
        return chaoBiaoGJDao.getChaoBiaoGJList(account);
    }

    @Override
    public synchronized List<ChaoBiaoGJ> getChaoBiaoGJList(String account, int renwuBH, String ch) {
        return chaoBiaoGJDao.getChaoBiaoGJList(account, renwuBH, ch);
    }

    @Override
    public synchronized List<YanChiBiao> getLiangGaoLiangDiYanChiSJ(String account, int loadType) {
        return yanChiBiaoDao.getLiangGaoLiangDiYanChiSJ(account, loadType);
    }

    @Override
    public synchronized List<WordsInfo> getWordsInfoList() {
        return wordsInfoDao.getWordsInfoList();
    }

    @Override
    public synchronized void updateChaoBiaoBeiZhu(String s_cid, String beiZhu) {
        chaoBiaoSJDao.updateChaoBiaoBeiZhu(s_cid, beiZhu);
    }

    @Override
    public synchronized void updateYanChiBeiZhu(String s_cid, String beiZhu) {
        yanChiBiaoDao.updateYanChiBeiZhu(s_cid, beiZhu);
    }

    @Override
    public synchronized List<DuoMeiTXX> getDuoMeiTXXList(String account, String cid, int type) {
        return duoMeiTXXDao.getDuoMeiTXXList(account, cid, type);
    }

    @Override
    public synchronized List<DuoMeiTXX> getDuoMeiTXXList(String account, String cid, String ch, int renwuBH, int type) {
        return duoMeiTXXDao.getDuoMeiTXXList(account, cid, ch, renwuBH, type);
    }

    @Override
    public synchronized void updateDuoMeiTXX(DuoMeiTXX duoMeiTXX) {
        duoMeiTXXDao.updateDuoMeiTXX(duoMeiTXX);
    }

    @Override
    public synchronized boolean updateBiaoKaXXPhoneNum(String CID, String phoneNum, String type) {
        return biaokaxxDao.updateBiaoKaXXPhoneNum(CID, phoneNum, type);
    }

    @Override
    public synchronized boolean IsExistencePhone(String cid) {
        return duoMeiTXXDao.IsExistencePhone(cid);
    }

    @Override
    public synchronized boolean updateChaoMa(int benCiCM, String CID) {
        return false;
    }

    @Override
    public synchronized boolean updateChaoBiaoSjYanChiYY(String cid, String yanChiYY) {
        return chaoBiaoSJDao.updateChaoBiaoSjYanChiYY(cid, yanChiYY);
    }

    @Override
    public synchronized boolean updateBiaoKaXXYanChiDialog(String cid, String kouJing, String biaoHao, long huanBiaoRQ) {
        return biaokaxxDao.updateBiaoKaXXYanChiDialog(cid, kouJing, biaoHao,
                huanBiaoRQ);
    }

    @Override
    public synchronized List<GongDan> getGongDanXXList(String account, int type) {
        return null;
    }

    @Override
    public synchronized GongDan getGongDanXX(String gongdanbh) {
        return null;
    }

    @Override
    public synchronized GongDan getPrevGongDanXX(String gongdanbh) {
        return null;
    }

    @Override
    public synchronized GongDan getNextGongDanXX(String gongdanbh) {
        return null;
    }

    @Override
    public synchronized boolean updateGongDanXX(GongDan gongDan) {
        return false;
    }

    @Override
    public synchronized boolean insertGongDanChaoBiaoZT(GongDanCHAOBIAOZT gd_chaoBiaoZT) {
        return false;
//        return gongDanChaoBiaoDao.insertGongDanChaoBiaoZT(gd_chaoBiaoZT);
    }

    @Override
    public synchronized void deleteGongDanYONGHUPZ() {
//        gongDanYongHuPZDao.deleteGongDanYongHuPZ();
    }

    @Override
    public synchronized void deleteGongDanWords() {
//        gongDanWordsDao.deleteGongDanWords();
    }

    @Override
    public synchronized boolean insertGongDanWords(GongDanWORDS gd_word) {
        return false;
//        return gongDanWordsDao.insertGongDanWords(gd_word);
    }

    @Override
    public synchronized void deleteGongDanChaoBiaoZT() {
//        gongDanChaoBiaoDao.deleteGongDanChaoBiaoZT();
    }

    @Override
    public synchronized boolean insertGongDanYONGHUPZ(GongDanYONGHUPZ gd_YongHuPZ) {
        return false;
//        return gongDanYongHuPZDao.insertGongDanYONGHUPZ(gd_YongHuPZ);
    }

    @Override
    public synchronized List<GongDanCHAOBIAOZT> getGongDanChaoBiaoZTList() {
        return null;
    }

    @Override
    public synchronized List<GongDanWORDS> getGongDanWords(int belongId) {
        return null;
    }

    @Override
    public synchronized List<GongDanWORDS> getGongDanWords() {
        return null;
    }

    @Override
    public synchronized List<GongDanYONGHUPZ> getGongDanYongHuPZList() {
        return null;
    }

    @Override
    public synchronized List<ChaoBiaoBZ> getChaoBiaoBZList() {
        return chaoBiaoBZDao.getChaoBiaoBZList();
    }

    @Override
    public synchronized List<GongDanYONGHUPZ> getGongDanYongHuPZList(int I_LISHUID) {
        return null;
    }

    @Override
    public synchronized List<GongDanYONGHUPZ> getGongDanYongHuPZList(int gangDantype, int ciyuLX, String CANSHUZ) {
        return null;
    }

    @Override
    public synchronized List<BIAOKAXX> getCombinedQuery(ConditionInfo info) {
        return biaokaxxDao.getCombinedQuery(info);
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getAllFinishedChaoBiaoSJ(int taskId, String volume, String account, int chaobiaobzYichao) {
        return chaoBiaoSJDao.getAllFinishedChaoBiaoSJ(taskId, volume, account, chaobiaobzYichao);
    }

    @Override
    public synchronized List<DuoMeiTXX> getAllDuoMeiTXXList(String account, int renwubh, String ch) {
        return duoMeiTXXDao.getAllDuoMeiTXXList(account, renwubh, ch);
    }

    @Override
    public synchronized List<BIAOKAXX> getAllBiaoKaXXList() {
        return biaokaxxDao.getAllBiaoKaXXList();
    }

    @Override
    public synchronized List<ChaoBiaoSJ> getAllChaoBiaoSJ(String account) {
        return chaoBiaoSJDao.getAllChaoBiaoSJ(account);
    }

    @Override
    public synchronized boolean deleteRecords(String account, int taskId, String volume,String cid) {
        return chaoBiaoSJDao.deleteRecords(account, taskId, volume, cid);
    }

    @Override
    public synchronized List<DuoMeiTXX> getAllDuoMeiTXXList(String account,String taskIdsArry) {
        return duoMeiTXXDao.getAllDuoMeiTXXList(account, taskIdsArry);
    }

    @Override
    public synchronized boolean deleteDuoMeiTXX(String account, List<String> mediaList) {
        return duoMeiTXXDao.deleteDuoMeiTXX(account,mediaList);
    }

    @Override
    public synchronized void deleteDuoMeiTXX(String account, int renwubh, String ch) {
        duoMeiTXXDao.deleteDuoMeiTXX(account, renwubh, ch);
    }

    @Override
    public synchronized void deleteCHaoBiaoRW(String taskId, String account) {
        chaoBiaoRWDao.delectChaoBiaoRW(account,taskId);
    }

    @Override
    public synchronized void deleteChaoBiaoRW(String account, int taskId, String ch) {
        chaoBiaoRWDao.delectChaoBiaoRW(account,taskId, ch);
    }

    @Override
    public synchronized void deleteChaoBiaoSJByTaskId(String account, String taskIdsArr) {
        chaoBiaoSJDao.deleteChaoBiaoSJByTaskId(account,taskIdsArr);
    }

    @Override
    public synchronized void deleteChaoBiaoRWByTaskId(String account, String taskIdsArry) {
        chaoBiaoRWDao.deleteChaoBiaoRWByTaskId(account,taskIdsArry);
    }

    @Override
    public synchronized boolean deleteDuoMeiTXXByTaskId(String account, String taskIdsArry) {
        return duoMeiTXXDao.deleteDuoMeiTXXByTaskId(account,taskIdsArry);
    }
}
