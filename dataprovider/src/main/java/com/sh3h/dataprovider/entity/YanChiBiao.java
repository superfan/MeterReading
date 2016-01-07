/**
 * @author zeng.jing
 *
 */
package com.sh3h.dataprovider.entity;

public class YanChiBiao {

	/**
	 * ID
	 */
	private int _ID;

	/**
	 * 任务编号
	 */
	private int _RENWUBH;

	/**
	 * 抄表ID（PK）
	 */
	private int _chaoBiaoId;

	/**
	 * 客户号
	 */
	private String _CID;

	/**
	 * 抄见水量
	 */
	private int _chaoJianSL;

	/**
	 * 上次抄码
	 */
	private int _shangCiCM;

	/**
	 * 抄回抄码
	 */
	private int _chaoHuiCM;
	/**
	 * 抄表状态编码
	 */
	private int _zhuangTaiBM;

	/**
	 * 抄表状态中文名称
	 */
	private String _zhuangTaiMC;

	/**
	 * 量高量低编码
	 */
	private int _liangGaoLDBM;

	/**
	 * 抄表日期
	 */
	private long _chaoBiaoRQ;

	/**
	 * 抄表年
	 */
	private int _chaoBiaoN;

	/**
	 * 抄表月
	 */
	private int _chaoBiaoY;

	/**
	 * 抄表员
	 */
	private String _chaoBiaoYuan;

	/**
	 * 抄表方式编码
	 */
	private int _fangShiBM;

	/**
	 * 抄表状态
	 */
	private int _chaoBiaoZT;

	/**
	 * 上次抄表日期
	 */
	private long _shangCiCBRQ;

	/**
	 * 站点
	 */
	private String _ST;

	/**
	 * 册本号
	 */
	private String _CH;

	/**
	 * 册内序号
	 */
	private int _ceNeiXH;

	/**
	 * 旧表抄码
	 */
	private int _jiuBiaoCM;

	/**
	 * 新表底码
	 */
	private int _xinBIaoDM;

	/**
	 * 换表日期
	 */
	private long _huanBiaoRQ;

	/**
	 * 换表回填时间
	 */
	private long _huanBiaoHTSJ;

	/**
	 * 登记时间
	 */
	private long _dengJiSJ;

	/**
	 * 状态
	 */
	private int _zhuangTai;

	/**
	 * 延迟员编号
	 */
	private String _yanChiYBH;

	/**
	 * 回填员编号
	 */
	private String _huiTianYBH;

	/**
	 * 回填时间
	 */
	private long _HUITIANSJ;

	/**
	 * 处理情况
	 */
	private String _chuLiQK;

	/**
	 * 操作人
	 */
	private String _caoZuoR;

	/**
	 * 操作时间
	 */
	private long _caoZuoSJ;

	/**
	 * 换表方式
	 */
	private int _huanBiaoFS;

	/**
	 * 抄表备注
	 */
	private String _chaoBiaoBZ;

	/**
	 * 水表条形码
	 */
	private String _shuiBiaoTXM;

	/**
	 * 延迟原因
	 */
	private String _yanChiYY;

	/**
	 * 真实抄码
	 */
	private int _zhenShiCM;

	/**
	 * 0用水量说明
	 */
	private int _linYongSLSM;

	/**
	 * 经度
	 */
	private String _x;

	/**
	 * 纬度
	 */
	private String _y;

	/**
	 * 延迟类型
	 */
	private int _yanChiLX;

	/**
	 * 延迟单编号
	 */
	private String _yanChiDBH;

	/**
	 * 抄表标志
	 */
	private int I_chaoBiaoBZ;

	/**
	 * 上传标志
	 */
	private int I_shangChuanBZ;

	/**
	 * 开账标志
	 */
	private int I_kaiZhangBZ;

	/**
	 * 简号
	 */
	private String S_JH;

	/**
	 * 量高水量
	 */
	private int I_liangGaoSL;

	/**
	 * 量低水量
	 */
	private int I_liangDiSL;

	/**
	 * 前三月平均量
	 */
	private int I_pingJunL1;

	/**
	 * 上次水量
	 */
	private int I_SHANGCISL;

	/**
	 * 开帐金额
	 */
	private double N_JE;

	private String S_JIETITS;

	private int S_ShangCiZTBM;

	public int getS_ShangCiZTBM() {
		return S_ShangCiZTBM;
	}

	public void setS_ShangCiZTBM(int s_ShangCiZTBM) {
		S_ShangCiZTBM = s_ShangCiZTBM;
	}

	public String getS_JIETITS() {
		return S_JIETITS;
	}

	public void setS_JIETITS(String s_JIETITS) {
		S_JIETITS = s_JIETITS;
	}

	public int getI_chaoBiaoBZ() {
		return I_chaoBiaoBZ;
	}

	public void setI_chaoBiaoBZ(int chaoBiaoBZ) {
		I_chaoBiaoBZ = chaoBiaoBZ;
	}

	public int getI_shangChuanBZ() {
		return I_shangChuanBZ;
	}

	public void setI_shangChuanBZ(int shangChuanBZ) {
		I_shangChuanBZ = shangChuanBZ;
	}

	public int getI_kaiZhangBZ() {
		return I_kaiZhangBZ;
	}

	public void setI_kaiZhangBZ(int kaiZhangBZ) {
		I_kaiZhangBZ = kaiZhangBZ;
	}

	public int getID() {
		return _ID;
	}

	public void setID(int ID) {
		this._ID = ID;
	}

	public int getRENWUBH() {
		return _RENWUBH;
	}

	public void setRENWUBH(int RENWUBH) {
		this._RENWUBH = RENWUBH;
	}

	public int getchaoBiaoId() {
		return _chaoBiaoId;
	}

	public void setchaoBiaoId(int chaoBiaoId) {
		this._chaoBiaoId = chaoBiaoId;
	}

	public String getCID() {
		return _CID;
	}

	public void setCID(String CID) {
		this._CID = CID;
	}

	public int getchaoJianSL() {
		return _chaoJianSL;
	}

	public void setchaoJianSL(int chaoJianSL) {
		this._chaoJianSL = chaoJianSL;
	}

	public int getshangCiCM() {
		return _shangCiCM;
	}

	public void setshangCiCM(int shangCiCM) {
		this._shangCiCM = shangCiCM;
	}

	public int getchaoHuiCM() {
		return _chaoHuiCM;
	}

	public void setchaoHuiCM(int chaoHuiCM) {
		this._chaoHuiCM = chaoHuiCM;
	}

	public int getzhuangTaiBM() {
		return _zhuangTaiBM;
	}

	public void setzhuangTaiBM(int zhuangTaiBM) {
		this._zhuangTaiBM = zhuangTaiBM;
	}

	public String getzhuangTaiMC() {
		return _zhuangTaiMC;
	}

	public void setzhuangTaiMC(String zhuangTaiMC) {
		this._zhuangTaiMC = zhuangTaiMC;
	}

	public int getliangGaoLDBM() {
		return _liangGaoLDBM;
	}

	public void setliangGaoLDBM(int liangGaoLDBM) {
		this._liangGaoLDBM = liangGaoLDBM;
	}

	public long getchaoBiaoRQ() {
		return _chaoBiaoRQ;
	}

	public void setchaoBiaoRQ(long chaoBiaoRQ) {
		this._chaoBiaoRQ = chaoBiaoRQ;
	}

	public int getchaoBiaoN() {
		return _chaoBiaoN;
	}

	public void setchaoBiaoN(int chaoBiaoN) {
		this._chaoBiaoN = chaoBiaoN;
	}

	public int getchaoBiaoY() {
		return _chaoBiaoY;
	}

	public void setchaoBiaoY(int chaoBiaoY) {
		this._chaoBiaoY = chaoBiaoY;
	}

	public String getchaoBiaoYuan() {
		return _chaoBiaoYuan;
	}

	public void setchaoBiaoYuan(String chaoBiaoYuan) {
		this._chaoBiaoYuan = chaoBiaoYuan;
	}

	public int getfangShiBM() {
		return _fangShiBM;
	}

	public void setfangShiBM(int fangShiBM) {
		this._fangShiBM = fangShiBM;
	}

	public int getchaoBiaoZT() {
		return _chaoBiaoZT;
	}

	public void setchaoBiaoZT(int chaoBiaoZT) {
		this._chaoBiaoZT = chaoBiaoZT;
	}

	public long getshangCiCBRQ() {
		return _shangCiCBRQ;
	}

	public void setshangCiCBRQ(long shangCiCBRQ) {
		this._shangCiCBRQ = shangCiCBRQ;
	}

	public String getST() {
		return _ST;
	}

	public void setST(String ST) {
		this._ST = ST;
	}

	public String getCH() {
		return _CH;
	}

	public void setCH(String CH) {
		this._CH = CH;
	}

	public int getceNeiXH() {
		return _ceNeiXH;
	}

	public void setceNeiXH(int ceNeiXH) {
		this._ceNeiXH = ceNeiXH;
	}

	public int getjiuBiaoCM() {
		return _jiuBiaoCM;
	}

	public void setjiuBiaoCM(int jiuBiaoCM) {
		this._jiuBiaoCM = jiuBiaoCM;
	}

	public int getxinBIaoDM() {
		return _xinBIaoDM;
	}

	public void setxinBIaoDM(int xinBIaoDM) {
		this._xinBIaoDM = xinBIaoDM;
	}

	public long gethuanBiaoRQ() {
		return _huanBiaoRQ;
	}

	public void sethuanBiaoRQ(long huanBiaoRQ) {
		this._huanBiaoRQ = huanBiaoRQ;
	}

	public long gethuanBiaoHTSJ() {
		return _huanBiaoHTSJ;
	}

	public void sethuanBiaoHTSJ(long huanBiaoHTSJ) {
		this._huanBiaoHTSJ = huanBiaoHTSJ;
	}

	public long getdengJiSJ() {
		return _dengJiSJ;
	}

	public void setdengJiSJ(long dengJiSJ) {
		this._dengJiSJ = dengJiSJ;
	}

	public int getzhuangTai() {
		return _zhuangTai;
	}

	public void setzhuangTai(int zhuangTai) {
		this._zhuangTai = zhuangTai;
	}

	public String getyanChiYBH() {
		return _yanChiYBH;
	}

	public void setyanChiYBH(String yanChiYBH) {
		this._yanChiYBH = yanChiYBH;
	}

	public String gethuiTianYBH() {
		return _huiTianYBH;
	}

	public void sethuiTianYBH(String huiTianYBH) {
		this._huiTianYBH = huiTianYBH;
	}

	public long getHUITIANSJ() {
		return _HUITIANSJ;
	}

	public void setHUITIANSJ(long HUITIANSJ) {
		this._HUITIANSJ = HUITIANSJ;
	}

	public String getchuLiQK() {
		return _chuLiQK;
	}

	public void setchuLiQK(String chuLiQK) {
		this._chuLiQK = chuLiQK;
	}

	public String getcaoZuoR() {
		return _caoZuoR;
	}

	public void setcaoZuoR(String caoZuoR) {
		this._caoZuoR = caoZuoR;
	}

	public long getcaoZuoSJ() {
		return _caoZuoSJ;
	}

	public void setcaoZuoSJ(long caoZuoSJ) {
		this._caoZuoSJ = caoZuoSJ;
	}

	public int gethuanBiaoFS() {
		return _huanBiaoFS;
	}

	public void sethuanBiaoFS(int huanBiaoFS) {
		this._huanBiaoFS = huanBiaoFS;
	}

	public String getchaoBiaoBZ() {
		return _chaoBiaoBZ;
	}

	public void setchaoBiaoBZ(String chaoBiaoBZ) {
		this._chaoBiaoBZ = chaoBiaoBZ;
	}

	public String getshuiBiaoTXM() {
		return _shuiBiaoTXM;
	}

	public void setshuiBiaoTXM(String shuiBiaoTXM) {
		this._shuiBiaoTXM = shuiBiaoTXM;
	}

	public String getyanChiYY() {
		return _yanChiYY;
	}

	public void setyanChiYY(String yanChiYY) {
		this._yanChiYY = yanChiYY;
	}

	public int getzhenShiCM() {
		return _zhenShiCM;
	}

	public void setzhenShiCM(int zhenShiCM) {
		this._zhenShiCM = zhenShiCM;
	}

	public int getlinYongSLSM() {
		return _linYongSLSM;
	}

	public void setlinYongSLSM(int linYongSLSM) {
		this._linYongSLSM = linYongSLSM;
	}

	public String getx() {
		return _x;
	}

	public void setx(String x) {
		this._x = x;
	}

	public String gety() {
		return _y;
	}

	public void sety(String y) {
		this._y = y;
	}

	public int getyanChiLX() {
		return _yanChiLX;
	}

	public void setyanChiLX(int yanChiLX) {
		this._yanChiLX = yanChiLX;
	}

	public String getyanChiDBH() {
		return _yanChiDBH;
	}

	public void setyanChiDBH(String yanChiDBH) {
		this._yanChiDBH = yanChiDBH;
	}

	public String getJH() {
		return S_JH;
	}

	public void setJH(String JH) {
		S_JH = JH;
	}

	public int getliangGaoSL() {
		return I_liangGaoSL;
	}

	public void setliangGaoSL(int liangGaoSL) {
		I_liangGaoSL = liangGaoSL;
	}

	public int getliangDiSL() {
		return I_liangDiSL;
	}

	public void setliangDiSL(int liangDiSL) {
		I_liangDiSL = liangDiSL;
	}

	public int getpingJunL1() {
		return I_pingJunL1;
	}

	public void setpingJunL1(int pingJunL1) {
		I_pingJunL1 = pingJunL1;
	}

	public int getI_shangCiSL() {
		return I_SHANGCISL;
	}

	public void setI_shangCiSL(int SHANGCISL) {
		I_SHANGCISL = SHANGCISL;
	}

	public double getJE() {
		return N_JE;
	}

	public void setJE(double JE) {
		N_JE = JE;
	}

}
