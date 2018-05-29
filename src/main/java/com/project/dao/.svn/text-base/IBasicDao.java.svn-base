/**
 * 
 */
package com.project.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.project.util.PageBean;

/**
 * @author howroad
 * @Date 2018年4月26日
 * @version 1.0
 */
public interface IBasicDao<T, K extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param t
	 *            实体
	 * @return 主键
	 */
	public K save(T t);

	/**
	 * 删除实体
	 * 
	 * @param id
	 *            主键
	 * @return boolean
	 */
	public boolean delete(K id);

	/**
	 * 删除实体
	 * 
	 * @param t
	 *            实体
	 * @return boolean
	 */
	public boolean delete(T t);

	/**
	 * 修改实体
	 * 
	 * @param t
	 *            实体
	 * @return boolean
	 */
	public boolean update(T t);

	/**
	 * 懒加载实体
	 * 
	 * @param id
	 *            主键
	 * @return 实体
	 */
	public T load(K id);

	/**
	 * 急加载实体
	 * 
	 * @param id
	 *            主键
	 * @return 实体
	 */
	public T get(K id);

	/**
	 * 获取实体集合
	 * 
	 * @return 实体集合
	 */
	public List<T> list();

	/**
	 * 根据条件，自定义HQL查询集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param objs
	 *            条件参数
	 * @return 集合
	 */
	public <E> List<E> list(String hql, Object... objs);

	/**
	 * 分页查询集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param start
	 *            开始位置
	 * @param size
	 *            每页显示条数
	 * @param objs
	 *            条件参数
	 * @return 集合
	 */
	public <E> List<E> listPage(String hql, int start, int size, Object... objs);

	/**
	 * 根据条件查询总行数
	 * 
	 * @param hql
	 *            HQL语句
	 * @param objs
	 *            条件参数
	 * @return 总行数
	 */
	public Long getCount(String hql, Object... objs);

	/**
	 * 根据条件，自定义HQL查询实体数据
	 * 
	 * @param hql
	 *            HQL语句
	 * @param objs
	 *            条件参数
	 * @return 实体数据
	 */
	public <E> E uniqueResult(String hql, Object... objs);

	/**
	 * 根据条件，自定义HQL查询集合，封装到PageBean
	 * 
	 * @param listHql
	 *            HQL语句
	 * @param countHql
	 *            HQL语句
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param objs
	 *            条件参数
	 * @return PageBean对象
	 */
	public PageBean<T> findAllPage(String listHql, String countHql, int pageNo, int pageSize, Object... objs);

	/**
	 * 删除多个实体
	 * 
	 * @param ids
	 *            主键数组
	 * @return boolean
	 */
	public boolean deleteManyById(Serializable... ids);

	/**
	 * 根据条件，自定义SQL查询实体数据
	 * 
	 * @param sql
	 *            SQL语句
	 * @param clazz
	 *            返回类型
	 * @param objs
	 *            条件参数
	 * @return 实体数据
	 */
	public <E> E uniqueResultBySQL(String sql, Class<E> clazz, Object... objs);

	/**
	 * 根据条件，自定义SQL查询集合
	 * 
	 * @param sql
	 *            SQL语句
	 * @param clazz
	 *            返回类型
	 * @param objs
	 *            条件参数
	 * @return 集合
	 */
	public <E> List<E> listBySQL(String sql, Class<E> clazz, Object... objs);

	/**
	 * 保存多个实体
	 * 
	 * @param collection
	 *            实体集合
	 * @return boolean
	 */
	public boolean saveMany(Collection<T> collection);

	/**
	 * 保存多个实体
	 * 
	 * @param es
	 *            实体数组
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean saveMany(T... ts);

	/**
	 * sql查询数量
	 * 
	 * @param sql
	 *            sql语句
	 * @param objects
	 *            参数
	 * @return 数量
	 */
	public Long countBySQL(String sql, Object... objects);
	
	/**
	 * 
	 * @param sql
	 * @param start
	 * @param size
	 * @param objs
	 * @return
	 */
	public <E> List<E> listPageBySQL(String sql, int start, int size, Object... objs);
	
	/**
	 * 
	 * @param listSql
	 * @param countSql
	 * @param pageNo
	 * @param pageSize
	 * @param objs
	 * @return
	 */
	public PageBean<T> findAllPageBySQL(String listSql, String countSql, int pageNo, int pageSize, Object... objs);
	
	/**
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	public List<T> listBySQL(String sql, Object... objs);
}
