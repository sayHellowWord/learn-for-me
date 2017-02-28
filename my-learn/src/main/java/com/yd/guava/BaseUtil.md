   
    在性能和速度方面NULL是廉价的
    
### Preconditions
-   Preconditions.checkNotNull();

    判断对象是否为空，为空则直接抛出异常
    
    使用案例
    
    
    this.field = checkNotNull(field);
     Objects.requireNonNull()

### Strings

-   Strings.isNullOrEmpty()

    判断字符串是否为空
-    emptyToNull(String)
-    nullToEmpty(String)

### equals
    Objects.equals

### hashCode
    guaua
     Objects.hashCode(Object...)
     Objects.hashCode(field1, field2, …, fieldn)
    jdk7
     Objects.hash(Object...)
     
###toString
    Objects.toStringHelper(this).add("x",1).toString()
    
###compare/compareTo
    
    public int compareTo(Foo than){
        return ComparisonChain.start().compare(thi.aString,that.aString).compare(thi.aString,that.baString).result();
    }
   
### Ordering
    