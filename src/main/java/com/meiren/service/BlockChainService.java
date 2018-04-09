package com.meiren.service;

import com.meiren.blockchain.common.io.BlockChainInput;
import com.meiren.blockchain.common.util.BlockChainFileUtils;
import com.meiren.blockchain.common.util.JsonUtils;
import com.meiren.blockchain.entity.Block;
import com.meiren.dao.DiskBlockIndexDAO;
import com.meiren.dataobject.DiskBlockIndexDO;
import com.meiren.vo.DiskBlockIndexVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @author jijiecong   （这里替换为自己的名字）
 * @ClassName: BlockChainService
 * @Description: ${todo}
 * @date 2018/4/8 15:35
 */
public class BlockChainService {

	@Autowired
	private DiskBlockIndexDAO diskBlockIndexDAO;

	private String pathDisk = "D:/meiren/blocks/";
	private String blockFilePrefix = "blk";
	private String blockFileExtension = ".dat";

	public List<DiskBlockIndexDO> searchDiskBlockIndex(){

		List<DiskBlockIndexDO> diskBlockIndexDOS = diskBlockIndexDAO.searchDiskBlockIndex();
		return diskBlockIndexDOS;
	}

	public Block readFromDisk(String blockHash) {
		int begin = 0;
		int end = 0;
		DiskBlockIndexDO diskBlockIndexDO_cur = diskBlockIndexDAO.findByBlockHash(blockHash);
		DiskBlockIndexDO diskBlockIndexDO_prev = diskBlockIndexDAO.findByNextBlockHash(blockHash);
		if(diskBlockIndexDO_prev == null || diskBlockIndexDO_cur.nFile != diskBlockIndexDO_prev.nFile){//第一个block获取block在新的dat文件的第一个
			begin = 0;
			end = diskBlockIndexDO_cur.nBlockPos;
		}else {
			begin = diskBlockIndexDO_prev.nBlockPos;
			end = diskBlockIndexDO_cur.nBlockPos;
		}
		String pathBlk = pathDisk;
		byte[] blockdata = BlockChainFileUtils.readFiletoByteArray(pathBlk+ blockFilePrefix +diskBlockIndexDO_cur.nFile+blockFileExtension);
		byte[] result = new byte[end - begin];
		System.arraycopy(blockdata, begin, result, 0, end - begin);
		BlockChainInput input = new BlockChainInput(result);
		Block block = null;
		try {
			block = new Block(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonUtils.printJson(block);
		return block;

	}
}
