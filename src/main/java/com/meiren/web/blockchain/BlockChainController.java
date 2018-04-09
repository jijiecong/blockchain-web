package com.meiren.web.blockchain;

import com.meiren.blockchain.entity.Block;
import com.meiren.blockchain.entity.Store;
import com.meiren.common.core.bind.annotation.FormModel;
import com.meiren.common.utils.DateUtils;
import com.meiren.dataobject.DiskBlockIndexDO;
import com.meiren.service.BlockChainService;
import com.meiren.vo.DiskBlockIndexVO;
import com.meiren.vo.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jijiecong   （这里替换为自己的名字）
 * @ClassName: BlockChainController
 * @Description: ${todo}
 * @date 2018/4/8 14:35
 */
@Controller
@RequestMapping("blockchain/")
public class BlockChainController {

	@Autowired
	private BlockChainService blockChainService;

	@RequestMapping("list")
	public ModelAndView familyLoginPasswordList() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("blockchain/list");
		List<DiskBlockIndexDO> diskBlockIndexDOS = blockChainService.searchDiskBlockIndex();
		List<DiskBlockIndexVO> diskBlockIndexVOS = new ArrayList<>();
		for(DiskBlockIndexDO diskBlockIndexDO: diskBlockIndexDOS){
			DiskBlockIndexVO diskBlockIndexVO = new DiskBlockIndexVO();
			BeanUtils.copyProperties(diskBlockIndexDO, diskBlockIndexVO);
			diskBlockIndexVO.setTimestamp(DateUtils.parseDateFormat(diskBlockIndexDO.getTimestamp()+"", "yyyy-MM-dd HH:mm:ss"));
			diskBlockIndexVOS.add(diskBlockIndexVO);
		}
		modelAndView.addObject("blockchainData", diskBlockIndexVOS);
		return modelAndView;
	}

	@RequestMapping("detail/{blockHash}")
	public ModelAndView viewDetail(@PathVariable String blockHash) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("blockchain/detail");
		Block block = blockChainService.readFromDisk(blockHash);
		List<String> storeList = new ArrayList<>();
		for(Store store: block.stores){
			storeList.add(new String(store.storeScript));
		}
		modelAndView.addObject("storeData", storeList);
		return modelAndView;
	}

	@RequestMapping(value = "/form")
	public void test(@FormModel("student") Student student){
		System.out.println(student.getName());
		System.out.println(student.getType());
	}
}
