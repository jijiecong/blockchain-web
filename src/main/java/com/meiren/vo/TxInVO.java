package com.meiren.vo;

/**
 * @author jijiecong   （这里替换为自己的名字）
 * @ClassName: TxInVO
 * @Description: ${todo}
 * @date 2018/4/24 14:40
 */
public class TxInVO {

	//引用交易的txHash，用于查询transaction
	public String txHash;

	//引用交易中输出的index
	public long outIndex;

	//引用交易中输出的数量
	public long value;

	//所属用户
	public String owner;

	public String merchant;

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public long getOutIndex() {
		return outIndex;
	}

	public void setOutIndex(long outIndex) {
		this.outIndex = outIndex;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
}
