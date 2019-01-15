package com.xinrui.common.pojo;

import lombok.Data;

/**
 * The param of mybaties-plus codeGenrator execute
 */
@Data
public class CodeGeneratorParam {

	/**
	 *projectPath
	 */
	private String projectPath;

	/**
	 * author
	 */
	private String author;
	/**
	 * the names of tables
	 */
	private String[] includeTablesNames;
}
