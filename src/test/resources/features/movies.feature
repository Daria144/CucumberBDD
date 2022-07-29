Feature: Planeta kino

Background: User is on Main Page
  Given User is on Main Page

  @regression @showtimes @e2e @first
  Scenario: User can buy tickets as a guest
    When User navigates to "Showtimes" page
    And User selects available session and seat
    And  User adds ticket to cart
    Then User select option to buy as guest

    @smoke @regression @movies
  Scenario: User tries to add movie to wishlist
    When User navigates to "Movies" page
    And User selects desirable movie
    Then User adds it to wishlist


      @movies @regression @fail
  Scenario: User can select only available technologies in the cinema
    When User navigates to "Showtimes" page
    And User selects "River Mall" cinema
    And User selects "4DX" technology
    And User selects "RE'LUX" technology
    And User selects "Forum Lviv" cinema
    Then Only "Rukhuk" technology is selected

        @showtimes @smoke @regression
  Scenario Outline: User filters movies by city, period and technology
    When User navigates to "Showtimes" page
    Then User filters movies by <cinema>, <period> and <technology>
    Examples:
      | cinema      | period   | technology |
      | Blockbuster | week     | 4DX        |
      | King Cross  | tomorrow | IMAX       |
      | APPOLO      | month    | Cinetech+  |

    @smoke @showtimes @regression
    Scenario: User can select VIP seats only in CINETECH+ technology
      When User navigates to "Showtimes" page
      And User select sessions in a "week"
      And User selects session in "4DX" technology
      Then No VIP seats are displayed
      And User navigates to "Showtimes" page
      And User disselects "4DX" technology
      And User selects session in "Cinetech+" technology
      Then VIP seats are available








