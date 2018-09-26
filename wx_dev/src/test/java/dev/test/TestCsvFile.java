package dev.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opencsv.CSVReader;
import com.wx.dev.biz.EmployeeCsvDataBiz;
import com.wx.dev.entity.TblEmployeecsvdata;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年1月13日下午3:00:35
 * @author: 周志刚
 * @ClassName: TestCsvFile
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCsvFile {

	public Log _log = LogFactory.getLog(TestCsvFile.class);

	public static String EMPLOYEE_CSV_CODE = "Code";
	public static String EMPLOYEE_CSV_C_NAME = "C_Name";
	public static String EMPLOYEE_CSV_SERVICESTATUS = "Servicestatus";
	public static String EMPLOYEE_CSV_PTCODE = "PTCode";
	public static String EMPLOYEE_CSV_OLDCODE = "OldCode";

	@Resource
	private EmployeeCsvDataBiz csvDataBiz;

	@Test
	@SuppressWarnings("resource")
	public void readCSV() throws IOException, SQLException {
		// TODO Auto-generated method stub

		InputStream is = new FileInputStream("F:/Employee.csv");
		InputStreamReader isr = new InputStreamReader(is);// 字符流
		CSVReader csvReader = new CSVReader(isr);
		List<String[]> list = csvReader.readAll();
		int line = 0;

		int readDataCode = 0, readDataName = 0, readDataServiceStatus = 0, readDataPTCode = 0, readDataOldCode = 0;

		for (String[] employee : list) {
			if (line == 0) {
				System.out.println("第一行数据：" + employee);
				// 读取标题
				for (int j = 0; j < employee.length; j++) {
					if (TestCsvFile.EMPLOYEE_CSV_CODE.equals(employee[j])) {
						readDataCode = j;
					} else if (TestCsvFile.EMPLOYEE_CSV_C_NAME
							.equals(employee[j])) {
						readDataName = j;
					} else if (TestCsvFile.EMPLOYEE_CSV_SERVICESTATUS
							.equals(employee[j])) {
						readDataServiceStatus = j;
					} else if (TestCsvFile.EMPLOYEE_CSV_PTCODE
							.equals(employee[j])) {
						readDataPTCode = j;
					} else if (TestCsvFile.EMPLOYEE_CSV_OLDCODE
							.equals(employee[j])) {
						readDataOldCode = j;
					}
				}
				System.out.println(employee[readDataOldCode] + ">>>>"
						+ employee[readDataServiceStatus] + ">>>>"
						+ employee[readDataName] + ">>>>"
						+ employee[readDataPTCode] + ">>>>"
						+ employee[readDataCode]);

			} else {

				if (StringUtils.isEmpty(employee[readDataOldCode])) {
					continue;
				}

				// 向DB存储数据
				TblEmployeecsvdata csvData = new TblEmployeecsvdata();
				csvData.setCode(employee[readDataCode]);
				csvData.setName(employee[readDataName]);
				csvData.setServicestatus(Integer
						.valueOf(employee[readDataServiceStatus]));
				csvData.setPtcode(employee[readDataPTCode]);
				csvData.setOldcode(employee[readDataOldCode]);

				TblEmployeecsvdata data = csvDataBiz
						.selectByCsv(employee[readDataOldCode]);

				// 添加
				if (data == null) {

					_log.info("执行添加");
					csvDataBiz.saveSelective(csvData);
					// 更新
				} else {

					_log.info("执行更新");
					data.setCode(employee[readDataCode]);
					data.setName(employee[readDataName]);
					data.setServicestatus(Integer
							.valueOf(employee[readDataServiceStatus]));
					data.setPtcode(employee[readDataPTCode]);
					data.setOldcode(employee[readDataOldCode]);
					data.setUpddate(new Date());

					csvDataBiz.updateSelective(data);
				}
			}
			line++;
		}
	}

}
