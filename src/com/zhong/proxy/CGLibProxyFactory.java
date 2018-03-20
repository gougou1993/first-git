package com.zhong.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * cglib代理工厂
 * @author admin
 *
 */
public class CGLibProxyFactory {

	private Object target;// 代理对象的真实目标对象

	public CGLibProxyFactory(Object target) {
		this.target = target;
	}
	/**
	 * 回调对象
	 */
	private Callback callback = new MethodInterceptor() {
		/**
        *
        * @param obj   代理对象--真实对象的类的子类的对象
        * @param method    当期调用方法
        * @param args  方法参数
        * @param methodProxy 被调用方法的代理对象(用于执行父类的方法)
        * @return
        * @throws Throwable
        */
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
			// 前置增强
			System.out.println("+ Before Advice ...");
			// 执行目标方法
			// Object result = method.invoke(target, args);
			Object result = methodProxy.invoke(target, args);
			// 后置增强
			System.out.println("+ After Advice ...");
			return result;
		}
	};
	
	/**
	 * 本篇介绍回调过滤器CallbackFilter
		一、作用
		在CGLib回调时可以设置对不同方法执行不同的回调逻辑，或者根本不执行回调。
		在JDK动态代理中并没有类似的功能，对InvocationHandler接口方法的调用对代理类内的所以方法都有效。
	 */
	private CallbackFilter callbackFilter = new CallbackFilter() {
		
		@Override
		public int accept(Method method) {
			
			if("getConcreteMethodB".equals(method.getName())){  
	            return 0;//Callback callbacks[0]  
	        }else if("getConcreteMethodA".equals(method.getName())){  
	            return 1;//Callback callbacks[1]  
	        }else if("getConcreteMethodFixedValue".equals(method.getName())){  
	            return 2;//Callback callbacks[2]  
	        }  
	        return 1;  
		}
	};
	/**
	 * 生成代理对象
	 * @return
	 */
	public Object createProxy() {
		// 1. 创建Enhancer（增强）对象
		Enhancer enhancer = new Enhancer();
		// 2. cglib创建代理, 对目标对象创建子对象
		enhancer.setSuperclass(target.getClass());
		// 3. 传入回调接口, 对目标增强
		enhancer.setCallback(callback);
		return enhancer.create();
	}
	/**
	 * Spring AOP的底层通过JDK/cglib动态代理为目标对象进行横向织入:
		1) 若目标对象实现了接口,则Spring使用JDK的java.lang.reflect.Proxy代理.
		2) 若目标对象没有实现接口,则Spring使用cglib库生成目标对象的子类.
		Spring只支持方法连接点,不提供属性连接.
		标记为final的方法不能被代理,因为无法进行覆盖.
		程序应优先对针对接口代理,这样便于程序解耦/维护.
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDAO proxy = (UserDAO) new CGLibProxyFactory(new UserDAO()).createProxy();
		proxy.add("addUser");
		proxy.get("getUser");
		
		//final method 没有执行增强部分的代码，也就是没有被代理
		proxy.finalMethod("finalMethod"); 
	}
}
