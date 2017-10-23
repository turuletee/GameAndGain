-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2017 a las 10:06:51
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `game`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answers`
--

CREATE TABLE `answers` (
  `answerId` int(11) NOT NULL,
  `answer` varchar(300) NOT NULL,
  `answer_Value` tinyint(1) NOT NULL,
  `questions_QuestionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `badges`
--

CREATE TABLE `badges` (
  `badgeId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `icon` blob NOT NULL,
  `value` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaigns`
--

CREATE TABLE `campaigns` (
  `campaignsId` int(11) NOT NULL,
  `name` varchar(70) NOT NULL,
  `maxScore` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `description` varchar(300) NOT NULL,
  `interests_InterestId` int(11) NOT NULL,
  `campaign_Types_Campaign_TypeId` int(11) NOT NULL,
  `campaign_States_Campaign_StateId` int(11) NOT NULL,
  `users_userId` int(11) NOT NULL,
  `project_projectId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaigns_has_questions`
--

CREATE TABLE `campaigns_has_questions` (
  `idCampaigns_has_Questions` int(11) NOT NULL,
  `questions_QuestionId` int(11) NOT NULL,
  `campaigns_CampaignsId` int(11) NOT NULL,
  `campaigns_Interests_InterestId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaigns_has_users`
--

CREATE TABLE `campaigns_has_users` (
  `idCampaigns_has_Users` int(11) NOT NULL,
  `campaigns_CampaignsId` int(11) NOT NULL,
  `users_UserId` int(11) NOT NULL,
  `campaigns_Score` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaign_states`
--

CREATE TABLE `campaign_states` (
  `campaign_StateId` int(11) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `campaign_states`
--

INSERT INTO `campaign_states` (`campaign_StateId`, `description`) VALUES
(1, 'Scratch'),
(2, 'Started'),
(3, 'Completed');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaign_types`
--

CREATE TABLE `campaign_types` (
  `campaign_TypeId` int(11) NOT NULL,
  `description` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `campaign_types`
--

INSERT INTO `campaign_types` (`campaign_TypeId`, `description`) VALUES
(1, 'Charity'),
(2, 'Educative');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `commentId` int(11) NOT NULL,
  `date` date NOT NULL,
  `comment` varchar(500) NOT NULL,
  `users_UserIdFrom` int(11) NOT NULL,
  `users_UserIdTo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `difficulties`
--

CREATE TABLE `difficulties` (
  `difficultyId` int(11) NOT NULL,
  `description` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `difficulties`
--

INSERT INTO `difficulties` (`difficultyId`, `description`) VALUES
(1, 'Easy'),
(2, 'Medium'),
(3, 'Hard');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donations`
--

CREATE TABLE `donations` (
  `donationId` int(11) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `projects_ProjectId` int(10) UNSIGNED NOT NULL,
  `projects_Users_UserId` int(11) NOT NULL,
  `projects_Users_Interests_InterestId` int(11) NOT NULL,
  `projects_Users_Roles_RoleId` int(11) NOT NULL,
  `projects_Project_States_Project_StateId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game_campaign`
--

CREATE TABLE `game_campaign` (
  `idGame_Campaign` int(11) NOT NULL,
  `state_idState` int(11) NOT NULL,
  `idCampaign` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game_mission`
--

CREATE TABLE `game_mission` (
  `idGame_Mission` int(11) NOT NULL,
  `state_idState` int(11) NOT NULL,
  `idCampaign` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idMission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game_questions`
--

CREATE TABLE `game_questions` (
  `idGame_Questions` int(11) NOT NULL,
  `state_idState` int(11) NOT NULL,
  `idCampaign` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idMission` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game_state`
--

CREATE TABLE `game_state` (
  `idState` int(11) NOT NULL,
  `state` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `game_state`
--

INSERT INTO `game_state` (`idState`, `state`) VALUES
(1, 'Pending'),
(2, 'Started'),
(3, 'Completed');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interests`
--

CREATE TABLE `interests` (
  `interestId` int(11) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `interests`
--

INSERT INTO `interests` (`interestId`, `description`) VALUES
(1, 'Educative'),
(2, 'Cultural'),
(3, 'Environmental');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `missions`
--

CREATE TABLE `missions` (
  `missionId` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `description` varchar(300) NOT NULL,
  `score` int(11) NOT NULL,
  `difficulties_DifficultyId` int(11) NOT NULL,
  `campaigns_CampaignsId` int(11) NOT NULL,
  `campaigns_Interests_InterestId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `player`
--

CREATE TABLE `player` (
  `id` bigint(20) NOT NULL,
  `dateOfBirth` datetime NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `projects`
--

CREATE TABLE `projects` (
  `projectId` int(10) UNSIGNED NOT NULL,
  `name` varchar(60) NOT NULL,
  `points_Needed` int(10) UNSIGNED NOT NULL,
  `acumulated_Points` int(10) UNSIGNED ZEROFILL NOT NULL,
  `creation_Date` date NOT NULL,
  `objective` varchar(500) NOT NULL,
  `users_UserId` int(11) NOT NULL,
  `users_Interests_InterestId` int(11) NOT NULL,
  `users_Roles_RoleId` int(11) NOT NULL,
  `project_States_Project_StateId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `project_states`
--

CREATE TABLE `project_states` (
  `project_StateId` int(11) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `project_states`
--

INSERT INTO `project_states` (`project_StateId`, `status`) VALUES
(1, 'Pending'),
(2, 'Finished'),
(3, 'Canceled');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `questions`
--

CREATE TABLE `questions` (
  `questionId` int(11) NOT NULL,
  `question` varchar(300) NOT NULL,
  `score` int(10) UNSIGNED ZEROFILL NOT NULL,
  `missionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`roleId`, `description`) VALUES
(1, 'Player'),
(2, 'Donor'),
(3, 'Beneficiary'),
(4, 'Campaign_Manager'),
(5, 'Admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `dateOfBirth` datetime NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `birthdate` date NOT NULL,
  `points` int(10) UNSIGNED ZEROFILL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `interests_InterestId` int(11) NOT NULL,
  `roles_RoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_receives_badges`
--

CREATE TABLE `users_receives_badges` (
  `idUsers_Receives_Badges` int(11) NOT NULL,
  `users_UserId` int(11) NOT NULL,
  `badges_BadgeId` int(11) NOT NULL,
  `value` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answerId`),
  ADD KEY `fk_Answers_Questions1` (`questions_QuestionId`);

--
-- Indices de la tabla `badges`
--
ALTER TABLE `badges`
  ADD PRIMARY KEY (`badgeId`);

--
-- Indices de la tabla `campaigns`
--
ALTER TABLE `campaigns`
  ADD PRIMARY KEY (`campaignsId`),
  ADD KEY `fk_Campaigns_Interests1` (`interests_InterestId`),
  ADD KEY `fk_Campaigns_Campaign_Types1` (`campaign_Types_Campaign_TypeId`),
  ADD KEY `fk_Campaigns_Campaign_States1` (`campaign_States_Campaign_StateId`),
  ADD KEY `fk_users_userId` (`users_userId`),
  ADD KEY `fk_project_project1` (`project_projectId`);

--
-- Indices de la tabla `campaigns_has_questions`
--
ALTER TABLE `campaigns_has_questions`
  ADD PRIMARY KEY (`idCampaigns_has_Questions`),
  ADD KEY `fk_Campaigns_has_Questions_Campaigns1` (`campaigns_CampaignsId`),
  ADD KEY `fk_Campaigns_has_Questions_Questions1` (`questions_QuestionId`),
  ADD KEY `fk_Campaigns_has_Questions_Interest1` (`campaigns_Interests_InterestId`);

--
-- Indices de la tabla `campaigns_has_users`
--
ALTER TABLE `campaigns_has_users`
  ADD PRIMARY KEY (`idCampaigns_has_Users`),
  ADD KEY `fk_Campaigns_has_Users_Campaigns1` (`campaigns_CampaignsId`),
  ADD KEY `fk_Campaigns_has_Users_Users1` (`users_UserId`);

--
-- Indices de la tabla `campaign_states`
--
ALTER TABLE `campaign_states`
  ADD PRIMARY KEY (`campaign_StateId`);

--
-- Indices de la tabla `campaign_types`
--
ALTER TABLE `campaign_types`
  ADD PRIMARY KEY (`campaign_TypeId`);

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `fk_Comments_Users1` (`users_UserIdFrom`),
  ADD KEY `fk_Comments_Users2` (`users_UserIdTo`);

--
-- Indices de la tabla `difficulties`
--
ALTER TABLE `difficulties`
  ADD PRIMARY KEY (`difficultyId`);

--
-- Indices de la tabla `donations`
--
ALTER TABLE `donations`
  ADD PRIMARY KEY (`donationId`),
  ADD KEY `fk_Donations_Projects1` (`projects_ProjectId`),
  ADD KEY `fk_Donations_Users1` (`projects_Users_UserId`),
  ADD KEY `fk_Donations_Interest1` (`projects_Users_Interests_InterestId`),
  ADD KEY `fk_Donations_Roles1` (`projects_Users_Roles_RoleId`),
  ADD KEY `fk_Donations_Project_States1` (`projects_Project_States_Project_StateId`);

--
-- Indices de la tabla `game_campaign`
--
ALTER TABLE `game_campaign`
  ADD PRIMARY KEY (`idGame_Campaign`),
  ADD KEY `fk_Game_Campaign_State1_idx` (`state_idState`),
  ADD KEY `fk_Game_Campaign_User1` (`idUser`),
  ADD KEY `fk_Game_Campaign_Campaigns1` (`idCampaign`);

--
-- Indices de la tabla `game_mission`
--
ALTER TABLE `game_mission`
  ADD PRIMARY KEY (`idGame_Mission`),
  ADD KEY `fk_Game_Mission_State1` (`state_idState`),
  ADD KEY `fk_Game_Mission_Campaigns1` (`idCampaign`),
  ADD KEY `fk_Game_Mission_User1` (`idUser`),
  ADD KEY `fk_Game_Mission_Mission1` (`idMission`);

--
-- Indices de la tabla `game_questions`
--
ALTER TABLE `game_questions`
  ADD PRIMARY KEY (`idGame_Questions`),
  ADD KEY `fk_Game_Questions_State1` (`state_idState`),
  ADD KEY `fk_Game_Questions_Campaigns1` (`idCampaign`),
  ADD KEY `fk_Game_Questions_User1` (`idUser`),
  ADD KEY `fk_Game_Questions_Mission1` (`idMission`),
  ADD KEY `fk_ Questions` (`idQuestion`);

--
-- Indices de la tabla `game_state`
--
ALTER TABLE `game_state`
  ADD PRIMARY KEY (`idState`);

--
-- Indices de la tabla `interests`
--
ALTER TABLE `interests`
  ADD PRIMARY KEY (`interestId`);

--
-- Indices de la tabla `missions`
--
ALTER TABLE `missions`
  ADD PRIMARY KEY (`missionId`),
  ADD KEY `fk_Missions_Difficulties1` (`difficulties_DifficultyId`),
  ADD KEY `fk_Missions_Campaigns1` (`campaigns_CampaignsId`),
  ADD KEY `fk_Missions_Interest1` (`campaigns_Interests_InterestId`);

--
-- Indices de la tabla `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`projectId`),
  ADD KEY `fk_Projects_Users1` (`users_UserId`),
  ADD KEY `fk_Projects_Interest1` (`users_Interests_InterestId`),
  ADD KEY `fk_Projects_Roles1` (`users_Roles_RoleId`),
  ADD KEY `fk_Projects_Project_States1` (`project_States_Project_StateId`);

--
-- Indices de la tabla `project_states`
--
ALTER TABLE `project_states`
  ADD PRIMARY KEY (`project_StateId`);

--
-- Indices de la tabla `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `fk_Missions_missions1` (`missionId`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`roleId`);

--
-- Indices de la tabla `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `fk_Users_Interests1` (`interests_InterestId`),
  ADD KEY `fk_Users_Roles1` (`roles_RoleId`);

--
-- Indices de la tabla `users_receives_badges`
--
ALTER TABLE `users_receives_badges`
  ADD PRIMARY KEY (`idUsers_Receives_Badges`),
  ADD KEY `fk_Users_has_Badges_Users` (`users_UserId`),
  ADD KEY `fk_Users_has_Badges_Badges1` (`badges_BadgeId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `answers`
--
ALTER TABLE `answers`
  MODIFY `answerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `badges`
--
ALTER TABLE `badges`
  MODIFY `badgeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campaigns`
--
ALTER TABLE `campaigns`
  MODIFY `campaignsId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campaigns_has_questions`
--
ALTER TABLE `campaigns_has_questions`
  MODIFY `idCampaigns_has_Questions` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campaigns_has_users`
--
ALTER TABLE `campaigns_has_users`
  MODIFY `idCampaigns_has_Users` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campaign_states`
--
ALTER TABLE `campaign_states`
  MODIFY `campaign_StateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `campaign_types`
--
ALTER TABLE `campaign_types`
  MODIFY `campaign_TypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `difficulties`
--
ALTER TABLE `difficulties`
  MODIFY `difficultyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `donations`
--
ALTER TABLE `donations`
  MODIFY `donationId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `game_campaign`
--
ALTER TABLE `game_campaign`
  MODIFY `idGame_Campaign` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `game_mission`
--
ALTER TABLE `game_mission`
  MODIFY `idGame_Mission` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `game_questions`
--
ALTER TABLE `game_questions`
  MODIFY `idGame_Questions` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `game_state`
--
ALTER TABLE `game_state`
  MODIFY `idState` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `interests`
--
ALTER TABLE `interests`
  MODIFY `interestId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `missions`
--
ALTER TABLE `missions`
  MODIFY `missionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `player`
--
ALTER TABLE `player`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `projects`
--
ALTER TABLE `projects`
  MODIFY `projectId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `project_states`
--
ALTER TABLE `project_states`
  MODIFY `project_StateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `questions`
--
ALTER TABLE `questions`
  MODIFY `questionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `roleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `users_receives_badges`
--
ALTER TABLE `users_receives_badges`
  MODIFY `idUsers_Receives_Badges` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `fk_Answers_Questions1` FOREIGN KEY (`questions_QuestionId`) REFERENCES `questions` (`questionId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `campaigns_has_questions`
--
ALTER TABLE `campaigns_has_questions`
  ADD CONSTRAINT `fk_Campaigns_has_Questions_Campaigns1` FOREIGN KEY (`campaigns_CampaignsId`) REFERENCES `campaigns` (`campaignsId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Campaigns_has_Questions_Interest1` FOREIGN KEY (`campaigns_Interests_InterestId`) REFERENCES `interests` (`interestId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Campaigns_has_Questions_Questions1` FOREIGN KEY (`questions_QuestionId`) REFERENCES `questions` (`questionId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
