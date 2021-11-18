///**
// * @description:
// * @author: lianghaohong
// * @date: 2021/11/17
// * @time: 5:08 下午
// * Copyright (C) 2021 Meituan All rights reserved
// */
//public class RPCDemo {
//    ThriftClientProxy  clientProxy = new ThriftClientProxy();
//
//    //调用方AppKey
//        clientProxy.setAppKey(rpcProfConfig.getAppkey());
//    //服务端AppKey
//        clientProxy.setRemoteAppkey(rpcProfConfig.getRemoteAppkey());
//    //类名
//        clientProxy.setGenericServiceName(rpcProfConfig.getGenericServiceName());
//    //调用服务类名对应的端口
//        clientProxy.setRemoteServerPort(rpcProfConfig.getRemoteServerPort());
//        clientProxy.setFilterByServiceName(true);
//    // 目前只支持json、json-common、json-simple
//        clientProxy.setGeneric(rpcProfConfig.getGeneric());
//    //超时时间
//        clientProxy.setTimeout(rpcProfConfig.getTimeout());
//    //builder
//        clientProxy.afterPropertiesSet();
//    //add hook
//    GenericService genericService = (GenericService)clientProxy.getObject();
//
//
//
//    String methodName = "";
//
//    List<String> paramTypeList = new ArrayList<>();
//        paramTypeList.add(valueClassFullName);
//    List<String> paramValueList = new ArrayList<>();
//        paramValueList.add(JacksonUtils.serialize("{}"));
//
//    String result = genericService.$invoke(methodName, paramTypeList, paramValueList);
//}
