package dev.test;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wx.dev.biz.MulitDataBiz;
import com.wx.dev.entity.TblMulitData;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月13日下午4:01:08
 * @author: 周志刚
 * @ClassName: MulitDataThread
 * @Description: TODO
 */
@Repository
public class MulitDataThread implements Runnable {

	@Resource
	private MulitDataBiz dataBiz;
	int i = 0;

	@SuppressWarnings("deprecation")
	@Override
	public void run() {

		for (;;) {
			i++;
			if (i < 10) {
				TblMulitData data = new TblMulitData();
				data.setCount(i + "");
				data.setMark(Thread.currentThread().getName());
				data.setCreatedate(new Date().toLocaleString());
				try {
					dataBiz.saveSelective(data);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
