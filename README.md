# SQLiteDatabase

In this example we can easily insert, update, delete and retrieve the data.

Declaration of Database:
  SQLiteDatabase db;
  db=openOrCreateDatabase("DATABASE_NAME",MODE_PRIVATE,null);
  
  Create Table:
  
  db.execSQL("create table if not exists TABLE_NAME(Column_name1 DataType,Column_name2 Datatype)");
