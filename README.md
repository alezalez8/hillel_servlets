LESSON 11 

На основе наработок по проекту, соединить backend часть вместе с фронтовой частью. <br> 
Также необходимо продумать DTO, которые будут передаваться непосредственно в модель данных <br>
и использоваться в представлениях для отображения на стороне конечного пользователя. <br>
Также необходимо разработать контроллеры, для операций по отображению сущностей согласного <br>
следующего шаблона (предлагаю реализовать на каждую главную сущность свой контроллер):



Вывод списка сущностей (остановок, транспортных средств, поездок) : метод доступа либо GET(но тогда <br>
все параметры фильтрации, пагинации и сортировки придется передавать в урле), либо POST (все данные <br>
по фильтрации, пагинации, сортировки можно удобно <br>
оформить DTO объектом и передавать в теле POST запроса);
примерный url GET запроса <br>
/vehicles?sortColumn=id&sortDirection=desc&filterKey=name&filterValue=bus1&pageNumber=1&pageSize=25,<br>
примерный url POST запроса - /vehicles, и конечно сам объект фильтрации передать в теле <br>
запроса.
Отображение полных сведений о выбранном объекте:
метод доступа GET<br>
примерный вид запроса /vehicle/{vehicleId} (пример - /vehicles/10)