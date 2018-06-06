package com.meiren.vo;

/**
 * @author jijiecong   （这里替换为自己的名字）
 * @ClassName: TransactionVO
 * @Description: ${todo}
 * @date 2018/4/24 14:33
 */
public class TransactionVO {

	public TxInVO[] txInVOS;

	public TxOutVO[] txOutVOS;

	public String operator;

	public String txHash;

	public TxInVO[] getTxInVOS() {
		return txInVOS;
	}

	public void setTxInVOS(TxInVO[] txInVOS) {
		this.txInVOS = txInVOS;
	}

	public TxOutVO[] getTxOutVOS() {
		return txOutVOS;
	}

	public void setTxOutVOS(TxOutVO[] txOutVOS) {
		this.txOutVOS = txOutVOS;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
}
