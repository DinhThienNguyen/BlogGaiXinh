alter SEQUENCE images_id_seq RESTART with 1;
alter SEQUENCE users_id_seq RESTART with 1;
alter SEQUENCE posts_id_seq RESTART with 1;
alter SEQUENCE comments_id_seq RESTART with 1;
insert into images(name) values('1.jpg');
insert into images(name) values('2.jpg');
insert into images(name) values('3.jpg');
insert into images(name) values('4.jpg');
insert into images(name) values('5.jpg');
insert into images(name) values('6.jpg');
insert into images(name) values('7.jpg');
insert into images(name) values('8.jpg');
insert into images(name) values('9.jpg');
insert into images(name) values('10.jpg');


insert into users(fullname, email, gender, username, password) values('Le Van A', 'thien1@gmail.com', 'Male', 'LeVanA', 'levana');
insert into users(fullname, email, gender, username, password) values('Le Van B', 'thien2@gmail.com', 'Male', 'LeVanB', 'levanb');
insert into users(fullname, email, gender, username, password) values('Le Van C', 'thien3@gmail.com', 'Male', 'LeVanC', 'levanc');
insert into users(fullname, email, gender, username, password) values('Le Van D', 'thien4@gmail.com', 'Male', 'LeVanD', 'levand');
insert into users(fullname, email, gender, username, password) values('Le Van E', 'thien5@gmail.com', 'Male', 'LeVanE', 'levane');
insert into users(fullname, email, gender, username, password) values('Le Van F', 'thien6@gmail.com', 'Male', 'LeVanF', 'levanf');
insert into users(fullname, email, gender, username, password) values('Le Van G', 'thien7@gmail.com', 'Male', 'LeVanG', 'levang');
insert into users(fullname, email, gender, username, password) values('Le Van H', 'thien8@gmail.com', 'Male', 'LeVanH', 'levanh');
insert into users(fullname, email, gender, username, password) values('Le Van I', 'thien9@gmail.com', 'Male', 'LeVanI', 'levani');
insert into users(fullname, email, gender, username, password) values('Le Van K', 'thien10@gmail.com', 'Male', 'LeVanK', 'levank');
insert into users(fullname, email, gender, username, password) values('USerTest', 'aaaan10@gmail.com', 'Male', 'user', '123456');

insert into posts(vote, createtimestamp, title, image_id, user_id) values(2, 1558866953, 'dudes', 3, 5);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(7, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 1, 6);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(5, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 8, 10);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(1, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 6, 7);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(8, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 5, 8);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(3, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 3, 3);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(2, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 2, 4);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(9, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 9, 6);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(4, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 4, 3);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(6, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 5, 2);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(3, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 8, 8);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(2, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 7, 4);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(7, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 3, 7);
insert into posts(vote, createtimestamp, title, image_id, user_id) values(1, 1558866953, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 9, 1);

insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 1, 3);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 1, 1);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 2, 6);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 2, 2);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 3, 4);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 3, 7);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 4, 5);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 4, 4);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 5, 9);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 5, 10);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 6, 5);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 6, 2);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 7, 3);
insert into comments(content, vote, createtimestamp, post_id, user_id) values('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.', 34, 1558866953, 7, 8);

insert into user_upvotedpost(user_id, post_id) values(1, 4);
insert into user_upvotedpost(user_id, post_id) values(1, 6);
insert into user_upvotedpost(user_id, post_id) values(1, 7);
insert into user_upvotedpost(user_id, post_id) values(1, 8);

insert into user_downvotedpost(user_id, post_id) values(1, 1);
insert into user_downvotedpost(user_id, post_id) values(1, 2);
insert into user_downvotedpost(user_id, post_id) values(1, 3);
insert into user_downvotedpost(user_id, post_id) values(1, 5);