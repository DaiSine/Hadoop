Shell命令行只是为了颜色好看..后缀为java

（1）向HDFS中上传任意文本文件，如果指定的文件在HDFS中已经存在，由用户指定是追加到原有文件末尾还是覆盖原有的文件；

Shell命令:
检查文件是否存在: ./hdfs dfs -test -e text.txt
(执行完这一句不会输出结果，需要继续输入命令" echo $?")
追加命令: ./hdfs dfs -appendToFile text.txt text.txt

//
./hdfs dfs -copyToLocal text.txt /home/hadoop/local.txt
sudo sh -c "cat /home/hadoop/text.txt >> /home/hadoop/local.txt" //追加的内容
./hdfs dfs -cp -f file:///home/hadoop/text.txt text.txt
//


覆盖命令1: ./hdfs dfs -copyFromLocal -f local.txt text.txt

覆盖命令2: ./hdfs dfs -cp -f file:///home/hadoop/text.txt text.txt

（2）从HDFS中下载指定文件，如果本地文件与要下载的文件名称相同，则自动对下载的文件重命名；

Shell命令：

if $(./hdfs dfs -test -e file:///home/hadoop/text.txt);
then $(./hdfs dfs -copyToLocal text.txt /home/hadoop/text2.txt); 
else $(./hdfs dfs -copyToLocal text.txt ./text.txt); 
fi

（3）将HDFS中指定文件的内容输出到终端中；

Shell命令：
./hdfs dfs -cat text.txt

（4）显示HDFS中指定的文件的读写权限、大小、创建时间、路径等信息；
Shell命令：

./hdfs dfs -ls -h text.txt

（5）给定HDFS中某一个目录，输出该目录下的所有文件的读写权限、大小、创建时间、路径等信息，如果该文件是目录，则递归输出该目录下所有文件相关信息；

Shell命令：
./hdfs dfs -ls -R -h /user/hadoop/merge


（6）提供一个HDFS内的文件的路径，对该文件进行创建和删除操作。如果文件所在目录不存在，则自动创建目录；

Shell命令：

if $(./hdfs dfs -test -d input);
then $(./hdfs dfs -touchz input/text.txt); 
else $(./hdfs dfs -mkdir -p input && hdfs dfs -touchz input/text.txt); 
fi

删除文件：./hdfs dfs -rm input/text.txt


（7）提供一个HDFS的目录的路径，对该目录进行创建和删除操作。创建目录时，如果目录文件所在目录不存在则自动创建相应目录；删除目录时，由用户指定当该目录不为空时是否还删除该目录；

hell命令：

创建目录：./hdfs dfs -mkdir -p input
删除目录（如果目录非空则会提示not empty，不执行删除）：./hdfs dfs -rmdir input
强制删除目录：./hdfs dfs -rm -R input



（8）向HDFS中指定的文件追加内容，由用户指定内容追加到原有文件的开头或结尾；

Shell命令：

追加到文件末尾：./hdfs dfs -appendToFile text.txt text.txt

//
./hdfs dfs -copyToLocal text.txt /home/hadoop/local.txt
sudo sh -c "cat /home/hadoop/text.txt >> /home/hadoop/local.txt" //追加的内容
./hdfs dfs -cp -f file:///home/hadoop/local.txt text.txt
//

追加到文件开头：（由于没有直接的命令可以操作，方法之一是先移动到本地进行操作，再进行上传覆盖）：
./hdfs dfs -get text.txt
cat text.txt >> local.txt  
./hdfs dfs -copyFromLocal -f text.txt text.txt

//
./hdfs dfs -copyToLocal text.txt /home/hadoop/text.txt
sudo sh -c "cat /home/hadoop/text.txt >> /home/hadoop/local.txt" //追加的内容
./hdfs dfs -cp -f file:///home/hadoop/local.txt text.txt
//

（9）删除HDFS中指定的文件；

Shell命令：

./hdfs dfs -rm text.txt


（10）删除HDFS中指定的目录，由用户指定目录中如果存在文件时是否删除目录；
Shell命令：

删除目录（如果目录非空则会提示not empty，不执行删除）：./hdfs dfs -rmdir input
强制删除目录：./hdfs dfs -rm -R input

（11）在HDFS中，将文件从源路径移动到目的路径。

Shell命令：

./hdfs dfs -mv text.txt newtext.txt









1. 
FALSE	5610
TRUE	585


2. 

FALSE	6194
TRUE	1

33.
FALSE	6195








