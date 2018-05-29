/**
 * 
 */
package com.project.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.project.dao.IBasicDao;
import com.project.util.PageBean;

/**
 * @author howroad
 * @Date 2018年4月26日
 * @version 1.0
 */
public abstract class BasicDaoAdapter<T, K extends Serializable> implements IBasicDao<T, K> {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return this.hibernateTemplate.getSessionFactory();
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	private Class<T> clz;

	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if (clz == null) {
			clz = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass()))
					.getActualTypeArguments()[0]);
		}
		return clz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public K save(T t) {
		return (K) this.hibernateTemplate.save(t);
	}

	@Override
	public boolean delete(Serializable id) {
		try {
			this.hibernateTemplate.delete(load(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(T t) {
		try {
			this.hibernateTemplate.delete(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(T t) {
		try {
			this.hibernateTemplate.update(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public T load(Serializable id) {
		return this.hibernateTemplate.load(getClz(), id);
	}

	@Override
	public T get(Serializable id) {
		return this.hibernateTemplate.get(getClz(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return this.getSession().createQuery("from " + getClz().getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> list(String hql, Object... objs) {
		Query<E> query = this.getSession().createQuery(hql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> listPage(String hql, int start, int size, Object... objs) {
		Query<E> query = this.getSession().createQuery(hql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		return query.setFirstResult(start).setMaxResults(size).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getCount(String hql, Object... objs) {
		Query<T> query = this.getSession().createQuery(hql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E uniqueResult(String hql, Object... objs) {
		Query<E> query = this.getSession().createQuery(hql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		return query.uniqueResult();
	}

	@Override
	public PageBean<T> findAllPage(String listHql, String countHql, int pageNo, int pageSize, Object... objs) {
		return new PageBean<T>(listPage(listHql, (pageNo - 1) * pageSize, pageSize, objs), pageNo, pageSize,
				getCount(countHql, objs));
	}

	@Override
	public boolean deleteManyById(Serializable... ids) {
		try {
			for (Serializable id : ids) {
				this.getSession().delete(this.load(id));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public <E> E uniqueResultBySQL(String sql, Class<E> clazz, Object... objs) {
		NativeQuery<E> query = this.getSession().createNativeQuery(sql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i + 1, objs[i]);
			}
		}
		return query.setResultTransformer(Transformers.aliasToBean(clazz)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public <E> List<E> listBySQL(String sql, Class<E> clazz, Object... objs) {
		NativeQuery<E> query = this.getSession().createNativeQuery(sql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i + 1, objs[i]);
			}
		}
		return query.setResultTransformer(Transformers.aliasToBean(clazz)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listBySQL(String sql, Object... objs) {
		Query<T> query = this.getSession().createNativeQuery(sql).addEntity(getClz());
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i+1, objs[i]);
		}
		return query.list();
	}
	
	@Override
	public boolean saveMany(Collection<T> collection) {
		try {
			for (T t : collection) {
				this.getSession().save(t);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean saveMany(T... ts) {
		try {
			for (int i = 0; i < ts.length; i++) {
				this.getSession().save(ts[i]);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long countBySQL(String sql,Object...objects) {
		Query<BigInteger> query =  this.getSession().createNativeQuery(sql);
		for(int i =0;i<objects.length;i++) {
			query.setParameter(i+1, objects[i]);
		}
		return query.uniqueResult().longValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> listPageBySQL(String sql, int start, int size, Object... objs) {
		Query<E> query = this.getSession().createNativeQuery(sql).addEntity(getClz());
		// 设置参数
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i + 1, objs[i]);
			}
		}
		return query.setFirstResult(start).setMaxResults(size).list();
	}
	
	@Override
	public PageBean<T> findAllPageBySQL(String listSql, String countSql, int pageNo, int pageSize, Object... objs){
		return new PageBean<T>(listPage(listSql, (pageNo - 1) * pageSize, pageSize, objs), pageNo, pageSize,
				getCount(countSql, objs));
	}
}
