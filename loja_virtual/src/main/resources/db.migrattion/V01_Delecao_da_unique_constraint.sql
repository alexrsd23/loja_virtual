select constraint_name from information_schema.constraint_column_usage
where table_name = 'tb_usuario_role' and column_name = 'role_id'
  and constraint_name <> 'unique_role_user';

alter table tb_usuario_role drop CONSTRAINT "uk_knqwkpyuh76xw0qtvka3qqblx";
