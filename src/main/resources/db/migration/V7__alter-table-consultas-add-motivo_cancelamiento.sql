alter table consultas add motivo_cancelamiento varchar(100);
update consultas set motivo_cancelamiento = "";