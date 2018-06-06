package com.meiren.service;

import com.meiren.blockchain.common.io.BlockChainInput;
import com.meiren.blockchain.common.util.BlockChainFileUtils;
import com.meiren.blockchain.common.util.JsonUtils;
import com.meiren.blockchain.entity.Block;
import com.meiren.dao.DiskBlockIndexDAO;
import com.meiren.dataobject.DiskBlockIndexDO;
import com.meiren.vo.DiskBlockIndexVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
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
		DiskBlockIndexDO diskBlockIndexDO = diskBlockIndexDAO.findByBlockHash(blockHash);
		return readFromDiskBySize(diskBlockIndexDO.getnFile(), diskBlockIndexDO.getnBlockPos(), diskBlockIndexDO.getnBlockSize());
	}

	public Block readFromDiskBySize(int nFile, int begin, int size){
		String pathBlk = pathDisk;
		Block block = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathBlk+ blockFilePrefix +nFile+blockFileExtension);
			fis.skip(begin);
			byte[] result = new byte[size];
			fis.read(result);
			BlockChainInput input = new BlockChainInput(result);
			block = new Block(input);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//		JsonUtils.printJson(block);
		return block;
	}

}
