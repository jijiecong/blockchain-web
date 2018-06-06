package com.meiren.vo;

/**
 * @author jijiecong   （这里替换为自己的名字）
 * @ClassName: TxOutVO
 * @Description: ${todo}
 * @date 2018/4/24 14:40
 */
public class TxOutVO {

	//交易hash，用于查询transaction
	public String txHash;

	//交易中输出的index
	public long outIndex;

	//交易中输出的数量
	public long value;

	//输出用户
	public String receiver;

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

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
}
