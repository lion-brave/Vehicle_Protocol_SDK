# Bus passenger flow platform

#### introduce
Bus passenger flow platform equipment access service demo


#### Project description
    hxzy-vehicledemo
    └─src
       └─main
          ├─java
          │  └─com
          │      └─hxzy
          │            └─vehicle
          │                   └─demo
          │                        ├─controller
          │                            └─UploadController.java              //File upload control class
          │                        ├─parse
          │                             ├─service
          │                                  ├─impl
          │                                      └─AsyncServiceImpl.java    //Document processing class
          │                                  └─AsyncService.java
          │                            └─FileListener.java                  //File listening
          │                            └─FileMonitor.java                   //File listener class
          │                         ├─util
          │                             └─Base64Utils.java
          │                             └─CoordinateTransformUtil.java
          │                             └─DateUtil.java
          │                             └─HMACSHA1.java
          │                             └─Md5Util.java
          │                             └─StringUtil.java
          │                         ├─vo
          │                             └─DevData.java
          │                             └─FileVo.java
          │                             └─UploadResponse.java
          │                         └─DemoApplication.java                  //Activation class
          └─resources
              ├─application.yml     //Configuration file
