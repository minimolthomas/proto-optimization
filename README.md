# proto-optimization

To run the test, clone repo  
export SRC_DIR=<cloned_dir>/ProtoBufSizeTest/src/main/resources/  
export DST_DIR=<cloned_dir>/ProtoBufSizeTest/src/main  
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/Sample.proto  
mvn clean compile exec:java  
